Приложение: CharacterFrequencyApplication 
Запуск приложения:
Для запуска приложения изначально требуется установить его на пк из git репозитория
Запуск самого приложения производится из главного класса CharacterFrequencyApplication
После запуска приложения требуется перейти в браузер и открыть URL: http://localhost:8080/api/character-frequency?inputString=
В данный URL нужно передать исследуемую строку. Например http://localhost:8080/api/character-frequency?inputString=dafdddeefdd
После чего будет возвращен JSON в котором будут указаны все переданные символы из строки и количество их вхождений в данную строку. Формат входящих данных может быть абсолютно любым, единственное условие,
строка не должна превышать 12 символов.