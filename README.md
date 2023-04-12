![PROJECT_PHOTO](https://github.com/StanislavSokolov/SET12MA/blob/main/scr_01.jpg)
# Мобильное приложение для управления высокольтными преобразователями частоты через bluetooth или USB соединение.
* [Описание проекта](#chapter-0)
* [Устройства для коммуникации](#chapter-1)
* [Интерфейсы и протоколы](#chapter-2)

<a id="chapter-0"></a>
## Описание проекта
- Графический пользовательский интерфейс предназначен для управления и диагностики преобразователей частоты в составе единых электроэнергетических систем. Мобильный пост управления для коммуникации между человеком-оператором и высокольтным (или любым другим) оборудованием.

<a id="chapter-1"></a>
## Устройства для коммуникации
- Для коммуникации с системой управления преобразователем частоты необходимо иметь преобразователь USB-to-RS232 ADAM-4561 от фирмы "Advantech"
![PROJECT_PHOTO](https://github.com/StanislavSokolov/SET12MA/blob/main/scr_02.jpg)
- или преобразователь bluetooth-to-RS232 Parani SD1000 от фирмы "Sena Technologies"
![PROJECT_PHOTO](https://github.com/StanislavSokolov/SET12MA/blob/main/scr_03.png)
- Если "на борту" ситемы управления уже есть USB converter, то необходимо, чтобы он был стандартных серий (FTDI, Silabs CP210x, Prolific PL2303x, Qinheng CH34x или даже CDC driver). В таком случае коммуникация работает без сбоев. 

<a id="chapter-2"></a>
## Интерфейсы и протоколы
- Как правило при перечисленных вводных на стороне "железа" используется RS232 (хотя, конечно же, при выборе другого преобразователя USB-to-RS485, например, проблем не будет). На стороне мобильного приложения USB или bluetooth. Если на стороне железа используется встроенный USB converter, то интерфейс более не преобразовывается и подключается к мобилке напрямую.
- Протокол "кастомный", для каждой "железяки" свой, уникальный. Приложение перебирает все доступные ей протоколы и ждет ответа на запросы. Так определяет с кем "имеет дело" и настраивается на коммуникацию.
