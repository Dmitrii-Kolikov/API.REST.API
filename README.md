# API.REST.SWAGGER

Цель проекта
###  Постановки задачи
1. Опсисание области автоматизации
 - Морские слжубы маленького государства "Островитяния"
 - 3 порта, каждый со своей вместимостью
 - 10 кораблей
 - Могут строится новые корабли, а старые списываться и отправляться в утиль
 - Море иногда штормит
2. Пользователь и функции
 - **Морское регистр:** списание в ввод новых кораблей, просмотр актуальных данных о портах и короблях;
 - **Службы портов:** анализ загрузки портов;
 - **Капитаны:** ведение информации о местоположении судна
 - **Береговая охрана** (служба спасения): актуальные сведения о короблях в море (на случай ухудшения погоды)
3. Ограничения и допущения
 - Не делаем разделения прав доступа пользователей к информации
 - Все корабли построены по одному проекту
 - Корабли строяться по одному(не может быть одновременного ввода 2+ кораблей)
 - Все места для швартовки в портах одного размера под типовое проект судна



### Rest. Общая информация
- Rest(Representational state transfer) - это стиль архитектуры API, который часто используется для построения веб-служб
- Rest является очень простым интерфейсом управления информацией. Каждая еденица информации однозначно определяется глобальным идентификатором(URL). Каждый URL имеет строго заданный формат.

| Данные | URL |
|----------------|---------|
| Все порты | /ports |
| Порт с id = 3 | /ports/3 |
| Все корабли из порта с id = 3 | /ports/3/ships |
| Коррабль с id = 5 из порта с id = 3 | /ports/3/ships/5 |
| ...и его команды | /ports/3/ships/5/crew |


### Rest. Управление
- Управление информацией основывается на протоколе передачи данных. Наиболее распростаненный протокол - HTTP

| Операция | CRUD | HTTP-метод | Идемпотентный |
|----------------|---------|---------|---------|
| Создать новые объекты | Create | POST | Нет |
| Получить сведения об объекте | Read | GET | да |
| Обновить существующий объект | Update | PUT(\*) | Да |
| Удалить существующий объекты | Delete | DELETE | Да(\*) |


### Rest. Реализация нашего проекта
| Пользователь | Функция | URL |
|----------------|---------|---------|
| Морской регистр | Просмотр данных о портах | GET/ports |
| Морской регистр | Просмотр данных о кораблях | GET/ships |
| Морской регистр | Ввод новых кораблей | POST/ships |
| Морской регистр | Списание кораблей | DELETE/ships/{id} |
| Служба порта | Анализ загрузки порта | GET/ports/{id}/capacity |
| Капитан | Введение информации о местоположении судна | GET/ships/{id}/status |
| Капитан | Введение информации о местоположении судна | UPDATE/ships/{id}/status |
| Береговая охрана | Сведения о кораблях в море | GET/ships(\*) |




### Rest. Endpoints
| URL | Метод | Вход | Выход |Ошибки |
|----------------|---------|---------|---------|---------|
| /ships | GET | (\*) | List\<Ship> |  - |
| /ships  | POST | Ship | id | Некорректная информация о корабле |
| /ships/{id} | DELETE | id | - | Корабль не найден |
| /ships/{id}/status  | GET | id | Корабль не найден |
| /ships/{id}/status  | PUT | id, status, port_id(\*) | String |Корабль не найден, Порт не найден, Некорректный статус, Порт не может принять корабль |
| /ports | GET | - | List\<Port> | - |
| /ports/{id}/capacity | GET | id | ? |  Порт не найден |








 Еще
- исрользуемый инструмент
- Обзор существующего приложения
- Введение в Rest-архитектуру
- Создание Rest сервисов
- Введение в Swagger
- Применение Swagger-аннотаций в коде
