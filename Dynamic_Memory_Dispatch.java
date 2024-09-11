class a {
    public void show() {
        System.out.println("In a show");
    }

}

class b extends a {
    public void show() {
        System.out.println("In b show");
    }
}

class c extends a {

    public void show() {
        System.out.println("in c show");
    }

}

public class Dynamic_Memory_Dispatch {
    public static void main(String[] args) {
        a OBJ = new b();
        OBJ.show();

        OBJ = new a();
        OBJ.show();

        OBJ = new c();
        OBJ.show();
    }
}
