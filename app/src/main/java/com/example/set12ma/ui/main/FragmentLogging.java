package com.example.set12ma.ui.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.set12ma.R;

import java.io.*;

public class FragmentLogging extends Fragment {
    private static final String ARG_SECTION_NUMBER = "Logging";

    private SpaceStatus spaceStatus;
    private ResultReceiverStatusSpace resultReceiverStatusSpace;

    private SpaceFileLogs spaceFileLogs;
    private ResultReceiverFileLogsSpace resultReceiverFileLogsSpace;

    private UpDateGraphicalDisplay upDateGraphicalDisplay;
    private long timer = 500;

    private LogsToFile logsToFile;

    private Button buttonDownload;
    private Button buttonSend;
    private ProgressBar progressBar;
    private ProgressBar progressBar2;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        resultReceiverStatusSpace = (ResultReceiverStatusSpace) context;
        resultReceiverFileLogsSpace = (ResultReceiverFileLogsSpace) context;
    }

    private PageViewModel pageViewModel;

    public static FragmentLogging newInstance(int index) {
        FragmentLogging fragment = new FragmentLogging();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
        spaceStatus = resultReceiverStatusSpace.getSpaceStatus();
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_logging, container, false);
        buttonDownload = root.findViewById(R.id.button_download);
        buttonSend = root.findViewById(R.id.button_send);

        spaceFileLogs = resultReceiverFileLogsSpace.getSpaceFileLogs();

        buttonDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
            }
        });
//        buttonSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                save();
//            }
//        });
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });


        progressBar2 = root.findViewById(R.id.progressBar2);
        progressBar2.setVisibility(View.INVISIBLE);
        progressBar = root.findViewById(R.id.progressBar);
        progressBar.setMax(175);
        progressBar.setVisibility(View.INVISIBLE);

        upDateGraphicalDisplay = new UpDateGraphicalDisplay();
        upDateGraphicalDisplay.start();

        return root;
    }

    private void download() {
        if (spaceStatus.isReadyFlagToExchangeData()) {
            if (!spaceStatus.isStatusProcessOfUpdatingSoftware() & !spaceStatus.isStatusProcessOfLoadingSoftware()) {
                if (!spaceStatus.isReadyFlagToDownloadLog()) {
                    Log.i("strartt", "start");
                    spaceStatus.setReadyFlagToDownloadLog(true);
                } else {
                    Toast.makeText(getContext(), "Дождитесь завершения загрузки логов", Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(getContext(), "Дождитесь завершения обновления ПО", Toast.LENGTH_LONG).show();
            }
        } else Toast.makeText(getActivity(), "Подключитесь к устройству", Toast.LENGTH_SHORT).show();

    }

    private void send() {
        if (!spaceStatus.isStatusProcessOfUpdatingSoftware() & !spaceStatus.isStatusProcessOfLoadingSoftware()) {
            if (!spaceStatus.isReadyFlagToDownloadLog()) {
                File file = new File(getContext().getFilesDir() + "/logs.txt");
                if (file.exists()) {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(file.getAbsolutePath()));
                    sendIntent.setType("application/txt*");

                    Intent shareIntent = Intent.createChooser(sendIntent, null);
                    startActivity(shareIntent);
                } else {
                    Toast.makeText(getActivity(), "Нет данных для отправки", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getContext(), "Дождитесь завершения загрузки логов", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getContext(), "Дождитесь завершения обновления ПО", Toast.LENGTH_LONG).show();
        }
    }

    public class UpDateGraphicalDisplay extends Thread {

        boolean state = false;
        boolean prevState = false;
        boolean latch = false;

        @Override
        public void run() {
            while (true) {
                try {
                    this.sleep(timer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (spaceStatus.isReadyFlagToDownloadLog()) {
                    if (!latch) {
                        progressBar2.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBar2.setVisibility(View.VISIBLE);
                            }
                        });
                        latch = true;
                    }
                    progressBar.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.VISIBLE);
                            progressBar.setProgress(spaceStatus.getProgressBarDownload());
                        }
                    });
                } else {
                    if (latch) {
                        progressBar2.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBar2.setVisibility(View.INVISIBLE);
                            }
                        });
                        progressBar.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setVisibility(View.INVISIBLE);
                            }
                        });
                        latch = false;
                    }
                }
                state = spaceStatus.isReadyFlagToDownloadLog();
                if (state == false & prevState == true) {
                    logsToFile = new LogsToFile();
                    logsToFile.start();
                }
                prevState = state;
                if (spaceStatus.isReadyFinishFlagToDownloadLog()) {
                    spaceStatus.setReadyFinishFlagToDownloadLog(false);
                    progressBar.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getContext(), "Файл logs.txt находится в дириктории приложения", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }

        }

        public UpDateGraphicalDisplay() {
        }
    }

    public class LogsToFile extends Thread {

        @Override
        public void run() {
            super.run();
            File file = new File(getContext().getFilesDir() + "/logs.txt");
            if (file.exists()) file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(file, true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < spaceFileLogs.getSpaceFileLogsArrayListSize(); i++) {
                byte[] bytes;
                bytes = spaceFileLogs.getSpaceFileLogsByte(i);
                try {
                    fileOutputStream.write(bytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            spaceStatus.setReadyFinishFlagToDownloadLog(true);
        }
    }
}
