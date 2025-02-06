// Description:
//
// Decorator pattern lets you dynamically change the behavior of an object at run time by wrapping
// them in an object of a decorator class. This allows new behavior to be added to an object
// without affecting the behavior of other objects of the same class.

interface Coffee {
  public int getCost();
  public String getDescription();
}

class SimpleCoffee implements Coffee {
  public SimpleCoffee() {}
  public int getCost() {
    return 10;
  }
  public String getDescription() {
    return "Simple coffee";
  }
}

class MilkCoffee implements Coffee {
  private Coffee SomeCoffee;
  public MilkCoffee(Coffee coffee) {
    this.SomeCoffee = coffee;
  }
  public int getCost() {
    return this.SomeCoffee.getCost() + 2;
  }
  public String getDescription() {
    return this.SomeCoffee.getDescription() + ", milk";
  }
}

class WhipCoffee implements Coffee {
  private Coffee SomeCoffee;
  public WhipCoffee(Coffee coffee) {
    this.SomeCoffee = coffee;
  }
  public int getCost() {
    return this.SomeCoffee.getCost() + 5;
  }
  public String getDescription() {
    return this.SomeCoffee.getDescription() + ", whip";
  }
}

class VanillaCoffee implements Coffee {
  private Coffee SomeCoffee;
  public VanillaCoffee(Coffee coffee) {
    this.SomeCoffee = coffee;
  }
  public int getCost() {
    return this.SomeCoffee.getCost() + 3;
  }
  public String getDescription() {
    return this.SomeCoffee.getDescription() + ", vanilla";
  }
}

class Decorator {
  public static void main(String[] args) {
    Coffee coffee = new SimpleCoffee();
    System.out.printf("%s is $%d\n", coffee.getDescription(), coffee.getCost());
    coffee = new MilkCoffee(coffee);
    System.out.printf("%s is $%d\n", coffee.getDescription(), coffee.getCost());
    coffee = new WhipCoffee(coffee);
    System.out.printf("%s is $%d\n", coffee.getDescription(), coffee.getCost());
    coffee = new VanillaCoffee(coffee);
    System.out.printf("%s is $%d\n", coffee.getDescription(), coffee.getCost());
  }
}
