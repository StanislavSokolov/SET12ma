package com.example.set12ma.ui.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.set12ma.R;

import java.io.*;
import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class FragmentLogging extends Fragment {
    private static final String ARG_SECTION_NUMBER = "Logging";

    private SpaceStatus spaceStatus;
    private ResultReceiverStatusSpace resultReceiverStatusSpace;

    private SpaceFileLogs spaceFileLogs;
    private ResultReceiverFileLogsSpace resultReceiverFileLogsSpace;

    private UpDateGraphicalDisplay upDateGraphicalDisplay;
    private long timer = 500;

    private LogsToFileInternalStorage logsToFileInternalStorage;
    private LogsToFileExternalStorage logsToFileExternalStorage;

    private Button buttonDownload;
    private Button buttonSend;
    private ProgressBar progressBar;
    private ProgressBar progressBar2;

    private EditText editTextStartOfRam;
    private EditText editTextLengthOfArray;
    private EditText editTextSizeOfBlock;

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
        progressBar.setMax(100);
        progressBar.setVisibility(View.INVISIBLE);

        editTextStartOfRam = root.findViewById(R.id.editText_start_of_ram);
        editTextStartOfRam.setText(Integer.toHexString(spaceFileLogs.getStartOfRAM()));
        editTextStartOfRam.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String text = editTextStartOfRam.getText().toString();
                    if (!text.equals("")) {
                        spaceFileLogs.setStartOfRAM(getIntFromString(text));
                    }
                }
                return true;
            }
        });

        editTextLengthOfArray = root.findViewById(R.id.editText2_length_of_array);
        editTextLengthOfArray.setText(Integer.toHexString(spaceFileLogs.getLengthOfArray()));
        editTextLengthOfArray.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String text = editTextLengthOfArray.getText().toString();
                    if (!text.equals("")) {
                        spaceFileLogs.setLengthOfArray(getIntFromString(text));
                    }
                }
                return true;
            }
        });

        editTextSizeOfBlock = root.findViewById(R.id.editText_size_of_block);
        editTextSizeOfBlock.setText(Integer.toHexString(spaceFileLogs.getSizeOfBlock()));
        editTextSizeOfBlock.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String text = editTextSizeOfBlock.getText().toString();
                    if (!text.equals("")) {
                        spaceFileLogs.setSizeOfBlock(getIntFromString(text));
                    }
                }
                return true;
            }
        });

        upDateGraphicalDisplay = new UpDateGraphicalDisplay();
        upDateGraphicalDisplay.start();

        return root;
    }

    private int getIntFromString(String text) {
        int data = 0;
        ArrayList<Integer> integers = new ArrayList<>();
        if (!text.equals("")) {
            for (char ch: text.toCharArray()) {
                integers.add(convertStringToInt(ch));
            }
            int j = 0;
            for (int i = integers.size() - 1; i > - 1; i--) {
                data = data + ((int) Math.pow(16, i)) * integers.get(j);
                j = j + 1;
            }
        }
        return data;
    }

    private Integer convertStringToInt(char ch) {
        if (ch == '0') return 0;
        else if (ch == '1') return 1;
        else if (ch == '2') return 2;
        else if (ch == '3') return 3;
        else if (ch == '4') return 4;
        else if (ch == '5') return 5;
        else if (ch == '6') return 6;
        else if (ch == '7') return 7;
        else if (ch == '8') return 8;
        else if (ch == '9') return 9;
        else if ((ch == 'A') || (ch == 'a')) return 10;
        else if ((ch == 'B') || (ch == 'b')) return 11;
        else if ((ch == 'C') || (ch == 'c')) return 12;
        else if ((ch == 'D') || (ch == 'd')) return 13;
        else if ((ch == 'E') || (ch == 'e')) return 14;
        else if ((ch == 'F') || (ch == 'f')) return 15;
        return 0;
    }

    private void download() {
        if (spaceStatus.isReadyFlagToExchangeData()) {
            if (!spaceStatus.isStatusProcessOfUpdatingSoftware() & !spaceStatus.isStatusProcessOfLoadingSoftware()) {
                if (!spaceStatus.isReadyFlagToDownloadLog()) {
                    progressBar.setMax(spaceFileLogs.getLengthOfArray()/spaceFileLogs.getSizeOfBlock());
                    spaceStatus.setReadyFlagToDownloadLog(true);
                } else {
                    Toast.makeText(getContext(), "Дождитесь завершения загрузки логов", Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(getContext(), "Дождитесь завершения обновления ПО", Toast.LENGTH_LONG).show();
            }
        } else Toast.makeText(getActivity(), "Подключитесь к устройству", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 10 && resultCode == RESULT_OK) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_STREAM, data.getData());
            sendIntent.setType("*/*");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        }
    }

    private void send() {
        if (!spaceStatus.isStatusProcessOfUpdatingSoftware() & !spaceStatus.isStatusProcessOfLoadingSoftware()) {
            if (!spaceStatus.isReadyFlagToDownloadLog()) {
                String state = Environment.getExternalStorageState();
                if (Environment.MEDIA_MOUNTED.equals(state)) {
                    Intent intent = new Intent()
                        .setType("*/*")
                        .setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent, "Select a file"), 10);
                } else {
                    Toast.makeText(getActivity(), "Идет разработка...", Toast.LENGTH_SHORT).show();

                    File file = new File(getContext().getFilesDir() + "/logs.txt");

                    if (file.exists()) {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(getContext().getFilesDir() + "/logs.txt"));
                    sendIntent.setType("*/*");

                    Intent shareIntent = Intent.createChooser(sendIntent, null);
                    startActivity(shareIntent);
                    } else {
                        Toast.makeText(getActivity(), "Нет данных для отправки", Toast.LENGTH_SHORT).show();
                    }
                }
//                Intent intent = new Intent()
//                        .setType("*/*")
//                        .setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(Intent.createChooser(intent, "Select a file"), 123);
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
                    String state = Environment.getExternalStorageState();
                    if (Environment.MEDIA_MOUNTED.equals(state)) {
                        logsToFileExternalStorage = new LogsToFileExternalStorage();
                        logsToFileExternalStorage.start();
                    } else {
                        logsToFileInternalStorage = new LogsToFileInternalStorage();
                        logsToFileInternalStorage.start();
                    }
//                    logsToFileInternalStorage = new LogsToFileInternalStorage();
//                    logsToFileInternalStorage.start();

                }
                prevState = state;
                if (spaceStatus.isReadyFinishFlagToDownloadLog()) {
                    spaceStatus.setReadyFinishFlagToDownloadLog(false);
                    String state = Environment.getExternalStorageState();
                    if (Environment.MEDIA_MOUNTED.equals(state)) {
                        progressBar.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getContext(), "Файл logs.txt находится в дириктории внутреннего общего накопителя " + getContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), Toast.LENGTH_LONG).show();
                            }
                        });
                    } else {
                        progressBar.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getContext(), "Файл logs.txt находится в дириктории приложения", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
//                    progressBar.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(getContext(), "Файл logs.txt находится в дириктории приложения", Toast.LENGTH_LONG).show();
//                        }
//                    });
                }
            }

        }

        public UpDateGraphicalDisplay() {
        }
    }

    public class LogsToFileExternalStorage extends Thread {

        @Override
        public void run() {
            super.run();
            File file = new File(getContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "logs.txt");
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

    public class LogsToFileInternalStorage extends Thread {

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
