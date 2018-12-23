
package Controlador;

import Modelo.ConsultasProducto;
import Modelo.Producto;
import VIsta.frmProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author miguel
 */
public class CtrlProducto implements ActionListener
{
    private Producto mod;
    private ConsultasProducto modC;
    private frmProducto frm;
    
    public CtrlProducto(Producto mod, ConsultasProducto modC, frmProducto frm)
    {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnCerrar.addActionListener(this);
    }
    
    public void iniciar()
    {
        frm.setTitle("Productos");
        frm.setLocationRelativeTo(null);
        frm.txtid.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == frm.btnGuardar) 
        {
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            
            if (modC.registrar(mod)) 
            {
                JOptionPane.showMessageDialog(null, "Producto Registrado");
                limpiar();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al guardar producto");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnModificar) 
        {
            mod.setId(Integer.parseInt(frm.txtid.getText()));
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            
            if (modC.modificar(mod)) 
            {
                JOptionPane.showMessageDialog(null, "Producto Modificar");
                limpiar();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al modificar producto");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnEliminar) 
        {
            mod.setId(Integer.parseInt(frm.txtid.getText()));
            
            if (modC.eliminar(mod)) 
            {
                JOptionPane.showMessageDialog(null, "Producto Eliminado");
                limpiar();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al eliminar producto");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnBuscar) 
        {
            mod.setCodigo(frm.txtCodigo.getText());
            
            if (modC.buscar(mod)) 
            {
                frm.txtid.setText(String.valueOf(mod.getId()));
                frm.txtCodigo.setText(mod.getCodigo());
                frm.txtCantidad.setText(String.valueOf(mod.getCantidad()));
                frm.txtNombre.setText(mod.getNombre());
                frm.txtPrecio.setText(String.valueOf(mod.getPrecio()));
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No se encontró el producto");
                limpiar();                
            }
        }
        
        if (e.getSource() == frm.btnLimpiar) 
        {
            limpiar();
        }
        
        if (e.getSource() == frm.btnCerrar) 
        {
            System.exit(0);
        }
    }
    
    public void limpiar()
    {
        frm.txtid.setText(null);
        frm.txtCantidad.setText(null);
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtPrecio.setText(null);
    }
    
}
