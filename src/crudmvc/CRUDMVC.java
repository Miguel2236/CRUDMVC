package crudmvc;

import Controlador.CtrlProducto;
import Modelo.ConsultasProducto;
import Modelo.Producto;
import VIsta.frmProducto;

/**
 *
 * @author miguel
 */
public class CRUDMVC 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Producto mod = new Producto();  //declaramos el objeto para hacer referencia a la clase
        ConsultasProducto modC = new ConsultasProducto();
        frmProducto frm = new frmProducto();
        
        CtrlProducto ctrl = new CtrlProducto(mod, modC, frm);
        
        ctrl.iniciar();
        frm.setVisible(true);
    }
    
}
