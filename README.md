# Задание 7 - Работа с БД
 
 **ФИО студента:** Ергин Игорь Константинович  
 **Преподаватель:** Карсканов Никита

 **Репозитории:**
 TDLRepo - Spring Data JPA для работы с таблицей tdl.
 EventRepo - Репозиторий Spring Data JPA для работы с таблицей event.
 
 
 
 **Модели:**
 TDL(ToDoList) - Модель представляющая таблицу tdl (список дел) в базе данных.

 @OneToMany(mappedBy = "toDoList", cascade = CascadeType.ALL): Устанавливает связь "один ко многим" с сущностью Event. Поле toDoList в Event указывает на обратную связь. 
 cascade = CascadeType.ALL означает, что операции (например, сохранение или удаление) на TDL каскадируются на связанные Event.
 
 Event - Модель представляющая таблицу event (событие) в базе данных.
 @ManyToOne: Устанавливает связь "многие к одному" с сущностью TDL.

 **Сервисы:**
 TDLService - Слой сервиса, содержащий бизнес-логику для работы со списками дел и событиями.
   Методы:
   createToDoList() -Устанавливает связь между переданным TDL и его событиями, вызывая event.setTDL(TDL) для каждого события.
   Сохраняет TDL в базе данных через TDLRepo.save(TDL). Благодаря cascade = CascadeType.ALL в TDL, связанные события также сохраняются.
   Возвращает сохранённый TDL.

   getToDoList() - Ищет список дел по имени через TDLRepo.findByName(name).
   Если список не найден, выбрасывает EntityNotFoundException.
   Возвращает найденный TDL.

   getAllList() - Возвращает все списки дел через TDLRepo.findAll().

   **Контроллер:**
   MainController - REST-контроллер, предоставляющий API для управления списками дел.
   @RestController: Помечает класс как REST-контроллер, где методы возвращают данные (обычно JSON) вместо представлений.
   @RequiredArgsConstructor: Генерирует конструктор для TDLService.

   **БД:**
   PostgreSQL хранит данные в таблицах:
     tdl: id (BIGINT, первичный ключ), name (VARCHAR).
     event: id (BIGINT, первичный ключ), event_text (TEXT), todo_list_id (BIGINT, внешний ключ).
   
   
