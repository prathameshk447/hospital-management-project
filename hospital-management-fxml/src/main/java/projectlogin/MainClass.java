package projectlogin;

public class MainClass {
  public static void main(String[] args) {
    MainClass m = new MainClass();
    m.printData();
  }

  public void printData() {
    String myClassName = getClass().getSimpleName() + ".class";
    System.out.println(myClassName);
    System.out.println(getClass().getResource(myClassName));
  }
}
