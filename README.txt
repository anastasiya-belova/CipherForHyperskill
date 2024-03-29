Эта программа может осуществлять шифровку и дешифровку строк.
В данный момент реализовано всего два алгоритма шифрования. Оба алгоритма 
основываются на коде Цезаря, основной идеей которого является замена символа в 
исходной строке на символ, полученный смещением по алфавиту на некоторое заранее 
заданное число (так называемый ключ).
Алгоритм "shift" - это классический код Цезаря. Изменяет только буквы английского 
алфавита, остальные символы переписывает без изменений.
Алгоритм "unicode" изменяет все символы, попадающие в переделы ячеек таблицы 
UNICODE от 32-й ячейки до 126-й ячейки включительно.

При запуске программы следует указать параметры в произвольном порядке:

   -alg - выбор алгоритма шифрования. Может быть shift или unicode. По умолчанию
будет выбран shift.

   -mode - выбор режима шифрования. Может быть enc или dec - шифровка или 
дешифровка соответственно. По умолчанию enc.

   -key - установка ключа. Любое целое число. По умолчанию 0.

   -data - исходная строка для шифрования. По умолчанию пустая ("").

   -in - этот параметр представляет собой путь к файлу, из которого будет
прочитана исходная строка для шифрования. В данный момент реализовано считывание
только первой строки из файла, но когда-нибудь я сделаю и многострочный ввод.
Если будут указаны оба параметра -data и -in, то предпочтение будет отдано -data.

   -out - этот параметр представляет собой путь к файлу, в который будет записан 
результат шифрования. Если файла с таким именем не существует, то программа его 
создаст. Если этот параметр не указан, то результат шифрования будет выведен в 
консоль.

Примеры запуска программы из командной строки.

Пример 1.
Ввод: java Main -mode enc -key 5 -data "Hello, world!" -alg unicode
Строка-результат: Mjqqt1%|twqi&

Пример 2.
Ввод: java Main -mode dec -key 5 -data "Mjqqt1%|twqi&" -alg unicode
Строка-результат: Hello, world!

Пример 3.
Ввод: java Main -mode enc -key 5 -data "Hello, world!"
Строка-результат: Mjqqt, btwqi!