# Inventory Management System - Documentation

## Project Overview
This project is an Inventory Management System designed to manage various types of items, handle payments, and process orders.

## Classes and Interfaces

### Interfaces

#### `Item`
- Represents items in the inventory.
- Methods: `getDetails()`, `calculateValue()`, `displayDescription()`.

#### `Categorizable`
- Represents items that can be categorized.
- Methods: `setCategory(String category)`, `getCategory()`.

#### `Breakable`
- Represents items that can break.
- Methods: `isBreakable()`, `handleBreakage()`.

#### `Perishable`
- Represents items that can perish.
- Methods: `isPerishable()`, `handleExpiration()`.

#### `Sellable`
- Represents items that can be sold.
- Methods: `calculateValue()`.

### Classes

#### `AbstractItem`
- An abstract class that implements all interfaces.
- Provides common functionality and default implementations for various attributes.

#### `InventoryItem`
- Extends `AbstractItem`.
- Represents a general item in the inventory, with attributes like item ID and quantity.

#### `ElectronicsItem`, `GroceryItem`, `FragileItem` (and other specific item classes)
- Extend `InventoryItem`.
- Specialized classes for different types of items with unique attributes and behaviors.

#### `Payment`
- Handles payment details, such as the payment amount.

#### `Order`
- Manages order details, including items and payment.
- Handles order processing, including payment processing and inventory updating.

#### `FileIOUtility`
- Utility class for file I/O operations.
- Handles saving and loading inventory data to and from text files.

#### `CLI` (Command-Line Interface)
- Handles user interactions.
- Allows users to manage inventory items, including adding, removing, and displaying items, and processing orders and payments.

## Methods Overview
Each class and interface includes various methods that handle specific functionalities related to inventory management, such as calculating value, handling breakage and expiration, processing payments, and user interactions.
