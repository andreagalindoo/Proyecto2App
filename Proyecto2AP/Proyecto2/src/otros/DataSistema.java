package otros;

import java.util.Date;
import modelo.Cliente;
import modelo.Empresa;
import modelo.Individual;
import modelo.ItemOrden;
import modelo.Orden;
import modelo.Producto;
import modelo.Usuario;

public class DataSistema {

    public static Cliente[] clientes1 = new Cliente[8];
    public static Producto[] productos1 = new Producto[8];
    public static Usuario[] usuarios = new Usuario[2];
    public static Orden[] ordenesA = new Orden[8];

    public static void cargarDatosClientes() {

        Individual individual1 = new Individual("2847098120101", "Mario Diaz", "10 avenida 22-91, zona1", "22220000", "individual");
        Individual individual2 = new Individual("2013776610101", "Diego Quiroa", "7a calle 3-01, zona 2", "23230000", "individual");
        Individual individual3 = new Individual("2222333330101", "Rosa Martinez", "4a avenida 34-74, zona 9", "24240000", "individual");
        Individual individual4 = new Individual("1010101010101", "Sofia Castillo", "6a calle 5-50, zona 10", "25250000", "individual");

        Empresa empresa1 = new Empresa("Luis Quintanilla", 20, "Los Angelitos, S.A.", "4a. Calle 3-81, zona 7", "22992299", "empresa");
        Empresa empresa2 = new Empresa("Fernando Ovalle", 25, "Los Marcianos, S.A.", "8a. Avenida 44-44, zona 5", "22778822", "empresa");
        Empresa empresa3 = new Empresa("Julio Monzon", 30, "Los Cochitos, S.A.",  "7a. Avenida 22-01, zona 1", "20202020", "empresa");
        Empresa empresa4 = new Empresa("Ricardo Montaner", 35, "Las Margaritas, S.A.", "10a. Calle 98-82, zona 2", "28484727",  "empresa");

        clientes1[0] = individual1;
        clientes1[1] = individual2;
        clientes1[2] = individual3;
        clientes1[3] = individual4;
        clientes1[4] = empresa1;
        clientes1[5] = empresa2;
        clientes1[6] = empresa3;
        clientes1[7] = empresa4;

    }

    public static void cargarDatosProductos() {
        Producto producto1 = new Producto("llantas", "180 anchura de llanta, 14 pulgadas diametro", 2500, 20);
        Producto producto2 = new Producto("escape", "silencioso", 350, 8);
        Producto producto3 = new Producto("amortiguador", "hidraulico, doble tubo", 460, 8);
        Producto producto4 = new Producto("radio", "usb, disco, bluetooth", 700, 4);
        Producto producto5 = new Producto("antena", "5 centimetros, 10 centimetro, 8 centimetros", 250, 7);
        Producto producto6 = new Producto("motor", "gasolina, diesel, electrico, GLP, GNC", 3500, 6);
        Producto producto7 = new Producto("platos", "negro, rojo, azul, verde", 200, 20);
        Producto producto8 = new Producto("parabrisas", "20 centimetros, 15 centimetros", 125, 14);

        productos1[0] = producto1;
        productos1[1] = producto2;
        productos1[2] = producto3;
        productos1[3] = producto4;
        productos1[4] = producto5;
        productos1[5] = producto6;
        productos1[6] = producto7;
        productos1[7] = producto8;
    }

    public static void UserInformation() {

        Usuario usuario1 = new Usuario("apgm", "apgm");
        Usuario usuario2 = new Usuario("pjre", "pjre");

        usuarios[0] = usuario1;
        usuarios[1] = usuario2;
    }

    public static void OrderInformation() {

        Orden orden1 = new Orden(new Date());
        orden1.setCliente(clientes1[0]);
        ItemOrden item1 = new ItemOrden(100 + orden1.getId(), 1, productos1[0]);
        ItemOrden item2 = new ItemOrden(200 + orden1.getId(), 2, productos1[1]);
        orden1.setItem1(item1);
        orden1.setItem2(item2);
        orden1.setPrecioEnvio(10000);
        orden1.setTipoEnvio("INMEDIATO");
        orden1.setEstado("EN TRAMITE");
        orden1.setDiasEnvio(3);
        orden1.getTotalOrden();

        Orden orden2 = new Orden(new Date());
        orden2.setCliente(clientes1[1]);
        ItemOrden item3 = new ItemOrden(100 + orden2.getId(), 2, productos1[0]);
        ItemOrden item4 = new ItemOrden(200 + orden2.getId(), 1, productos1[1]);
        orden2.setItem1(item3);
        orden2.setItem2(item4);
        orden2.setPrecioEnvio(10000);
        orden2.setTipoEnvio("INMEDIATO");
        orden2.setEstado("EN TRAMITE");
        orden2.setDiasEnvio(3);
        orden2.getTotalOrden();

       
        Orden orden3 = new Orden(new Date());
        orden3.setCliente(clientes1[2]);
        ItemOrden item5 = new ItemOrden(100 + orden3.getId(), 3, productos1[4]);
        ItemOrden item6 = new ItemOrden(200 + orden3.getId(), 2, productos1[5]);
        orden3.setItem1(item3);
        orden3.setItem2(item4);
        orden3.setPrecioEnvio(10000);
        orden3.setTipoEnvio("INMEDIATO");
        orden3.setEstado("EN TRAMITE");
        orden3.setDiasEnvio(3);
        orden3.getTotalOrden();

         
        Orden orden4 = new Orden(new Date());
        orden4.setCliente(clientes1[3]);
        ItemOrden item7 = new ItemOrden(100 + orden4.getId(), 2, productos1[6]);
        ItemOrden item8 = new ItemOrden(200 + orden4.getId(), 3, productos1[7]);
        orden4.setItem1(item7);
        orden4.setItem2(item8);
        orden4.setPrecioEnvio(100);
        orden4.setTipoEnvio("INMEDIATO");
        orden4.setEstado("EN TRAMITE");
        orden4.setDiasEnvio(5);
        orden4.getTotalOrden();

     
        Orden orden5 = new Orden(new Date());
        orden5.setCliente(clientes1[4]);
        ItemOrden item9 = new ItemOrden(100 + orden5.getId(), 3, productos1[1]);
        ItemOrden item10 = new ItemOrden(200 + orden5.getId(), 4, productos1[2]);
        orden5.setItem1(item9);
        orden5.setItem2(item10);
        orden5.setPrecioEnvio(10000);
        orden5.setTipoEnvio("INMEDIATO");
        orden5.setEstado("EN TRAMITE");
        orden5.setDiasEnvio(3);
        orden5.getTotalOrden();

        
        Orden orden6 = new Orden(new Date());
        orden6.setCliente(clientes1[5]);
        ItemOrden item11 = new ItemOrden(100 + orden6.getId(), 3, productos1[3]);
        ItemOrden item12 = new ItemOrden(200 + orden6.getId(), 2, productos1[4]);
        orden6.setItem1(item11);
        orden6.setItem2(item12);
        orden6.setPrecioEnvio(100);
        orden6.setTipoEnvio("INMEDIATO");
        orden6.setEstado("EN TRAMITE");
        orden6.setDiasEnvio(3);
        orden6.getTotalOrden();

       
        Orden orden7 = new Orden(new Date());
        orden7.setCliente(clientes1[6]);
        ItemOrden item13 = new ItemOrden(100 + orden3.getId(), 1, productos1[5]);
        ItemOrden item14 = new ItemOrden(200 + orden3.getId(), 2, productos1[6]);
        orden7.setItem1(item13);
        orden7.setItem2(item14);
        orden7.setPrecioEnvio(100);
        orden7.setTipoEnvio("INMEDIATO");
        orden7.setEstado("EN TRAMITE");
        orden7.setDiasEnvio(3);
        orden7.getTotalOrden();

        Orden orden8 = new Orden(new Date());
        orden8.setCliente(clientes1[7]);
        ItemOrden item15 = new ItemOrden(100 + orden3.getId(), 3, productos1[7]);
        ItemOrden item16 = new ItemOrden(200 + orden3.getId(), 4, productos1[0]);
        orden8.setItem1(item15);
        orden8.setItem2(item16);
        orden8.setPrecioEnvio(100);
        orden8.setTipoEnvio("INMEDIATO");
        orden8.setEstado("EN TRAMITE");
        orden8.setDiasEnvio(5);
        orden8.getTotalOrden();

        ordenesA[0] = orden1;
        ordenesA[1] = orden2;
        ordenesA[2] = orden3;
        ordenesA[3] = orden4;
        ordenesA[4] = orden5;
        ordenesA[5] = orden6;
        ordenesA[6] = orden7;
        ordenesA[7] = orden8;
        
   

    }

}
