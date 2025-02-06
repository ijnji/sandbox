// Description:
//
// Visitor pattern lets you add further operations to objects without having to modify them. It
// separates an algorithm from the object on which it operates. This allows new operations to be
// added without modifying the structure of those objects.

// Visitee
interface Animal {
  public void accept(AnimalOperation operation);
}

// Visitor
interface AnimalOperation {
  public void visitMonkey(Monkey monkey);
  public void visitLion(Lion lion);
  public void visitDolphin(Dolphin dolphin);
}

class Monkey implements Animal {
  public void shout() {
    System.out.println("Ooh oo aa aa!");
  }
  public void accept(AnimalOperation operation) {
    operation.visitMonkey(this);
  }
}

class Lion implements Animal {
  public void roar() {
    System.out.println("Roaaar!");
  }
  public void accept(AnimalOperation operation) {
    operation.visitLion(this);
  }
}

class Dolphin implements Animal {
  public void speak() {
    System.out.println("Tuut tuttu tuutt!");
  }
  public void accept(AnimalOperation operation) {
    operation.visitDolphin(this);
  }
}

class Speak implements AnimalOperation {
  public void visitMonkey(Monkey monkey) {
    monkey.shout();
  }
  public void visitLion(Lion lion) {
    lion.roar();
  }
  public void visitDolphin(Dolphin dolphin) {
    dolphin.speak();
  }
}

class Jump implements AnimalOperation {
  public void visitMonkey(Monkey monkey) {
    System.out.println("Jumped 20 feet high!");
  }
  public void visitLion(Lion lion) {
    System.out.println("Jumped 7 feet high!");
  }
  public void visitDolphin(Dolphin dolphin) {
    System.out.println("Walked on water a little and disappeared");
  }
}

class Visitor {
  public static void main(String[] args) {
    Monkey monkey = new Monkey();
    Lion lion = new Lion();
    Dolphin dolphin = new Dolphin();

    Speak speak = new Speak();
    monkey.accept(speak);
    lion.accept(speak);
    dolphin.accept(speak);

    Jump jump = new Jump();
    monkey.accept(jump);
    lion.accept(jump);
    dolphin.accept(jump);
  }
}
