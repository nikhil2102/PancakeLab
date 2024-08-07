+---------------------+
        |       Pancake       |
        +---------------------+
        | - orderId: UUID     |
        | - name: String      |
        | - ingredients: List<Ingredient> |
        +---------------------+
        | + getOrderId(): UUID |
        | + setOrderId(UUID)  |
        | + getName(): String |
        | + setName(String)   |
        | + getIngredients(): List<Ingredient> |
        | + setIngredients(List<Ingredient>) |
        +---------------------+
        ^
        |
        |
        +-----------------------+
        |    CustomPanCake      |
        +-----------------------+
        | + CustomPanCake(UUID, String, List<Ingredient>) |
        +-----------------------+

        +--------------------+                  +----------------------+
        |    Order           |                  |     Ingredient       |
        +--------------------+                  +----------------------+
        | - id: UUID         |                  | + DARK_CHOCOLATE     |
        | - building: int    |                  | + WHIPPED_CREAM      |
        | - room: int        |                  | + HAZELNUTS         |
        | - isCompleted: boolean |              | + MILK_CHOCOLATE    |
        +--------------------+                  +----------------------+
        | + getId(): UUID    |
        | + getBuilding(): int |
        | + getRoom(): int   |
        | + isCompleted(): boolean |
        | + setCompleted(boolean) |
        +--------------------+

        +---------------------------+                  +------------------------+
        |  PancakeRecipeFactory     |<>--------------- | PancakeRecipeFactoryImpl|
        +---------------------------+                  +------------------------+
        | + createPanCake(UUID, String, List<Ingredient>): Pancake |
        +---------------------------+                  | + createPanCake(UUID, String, List<Ingredient>): Pancake |
        +------------------------+

        +-------------------+                +--------------------+
        |  OrderIncompleteException          |        Database       |
        +-------------------+                +--------------------+
        | + OrderIncompleteException()       | - instance: Database|
        | + OrderIncompleteException(String) | - orders: Map<Integer, Order> |
        +-------------------+                | - orderIdCounter: int |
        | + getInstance(): Database |
        | + createOrder(Order): int |
        | + getOrder(int): Order |
        | + removeOrder(int) |
        +--------------------+

        +--------------------------+         +--------------------+
        |  ThirdPartyService       |         |        Chef         |
        +--------------------------+         +--------------------+
        | + roomNumberExists(int): boolean |  | + prepareOrder(Order) |
        | + buildingExists(int): boolean   |  +--------------------+
        +--------------------------+
        +--------------------+
        |  DeliveryService   |
        +--------------------+
        | + deliverOrder(Order): void |
        +--------------------+

        +--------------------+                +-------------------------+
        |    OrderLog        |                |     PancakeService      |
        +--------------------+                +-------------------------+
        | + logAddPancake(Order, String, List<Pancake>) |
        | + logRemovePancakes(Order, String, int, List<Pancake>) |
        | + logCancelOrder(Order, List<Pancake>) |
        | + logDeliverOrder(Order, List<Pancake>) |
        +--------------------+                | - orders: List<Order> |
        | - completedOrders: Set<UUID> |
        | - preparedOrders: Set<UUID> |
        | - pancakes: List<Pancake> |
        | + createOrder(int, int): Order |
        | + addDarkChocolatePancake(UUID, int) |
        | + addDarkChocolateWhippedCreamPancake(UUID, int) |
        | + addDarkChocolateWhippedCreamHazelnutsPancake(UUID, int) |
        | + addMilkChocolatePancake(UUID, int) |
        | + addMilkChocolateHazelnutsPancake(UUID, int) |
        | + viewOrder(UUID): List<String> |
        | + removePancakes(String, UUID, int) |
        | + cancelOrder(UUID) |
        | + completeOrder(UUID) |
        | + listCompletedOrders(): Set<UUID> |
        | + prepareOrder(UUID) |
        | + listPreparedOrders(): Set<UUID> |
        | + deliverOrder(UUID): Object[] |
        +-------------------------+
