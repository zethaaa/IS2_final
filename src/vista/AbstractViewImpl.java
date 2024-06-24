package vista;


import controlador.Controller;

public abstract class AbstractViewImpl <C extends Controller> extends javax.swing.JPanel
        implements View<C>{

    private C controller;
    
    public C getController() {
        return controller;
    }

    public void setController(C controller) {
        this.controller=controller;
    }

    public void dataModelChanged() {
        refresh();
    }

    protected abstract void refresh();

    public void display(){
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                setVisible(true);
                refresh();
            }
        });

    }

}
