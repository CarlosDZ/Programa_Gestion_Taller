package Main;
import dao.*;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;
import view.*;

public class Taller {
    private static final String NAME = "Nombre_Taller_Ejemplo";
    static Scanner scanner = new Scanner(System.in);


    public static String getName(){ return Taller.NAME; }


    //Funciones
    public static void newCliente(){
        System.out.println("Introduce el nombre que quieres darle a tu nuevo cliente.");
        String name = scanner.nextLine();

        System.out.println("Introduce su numero de telefono (Sin espacios, solo numeros)");
        String phone = scanner.next();

        System.out.println("Introduce su direccion (de cara a envios)");

        scanner.nextLine();
        String location = scanner.nextLine();

        int type;
        do{
            System.out.println("Elige el tipo de tu cliente: \n1 - Persona fisica\n2 - Empresa o grupo de personas\n3 - Otro");
            type = scanner.nextInt();
            if(type<1||type>3) System.out.println("El numero no esta en el rango, prueba de nuevo con un numero en el rango establecido.");
        }while(type<1||type>3);

        ClienteDAO.insert(new Cliente(name, phone, location, type));
    }
    public static void showAllClientes(){
        ArrayList<Cliente> lista_clientes = ClienteDAO.getAll();
        if(!lista_clientes.isEmpty()){
            System.out.println("-------------------------------------");
            ClienteView.quickGeneralView(lista_clientes);
            System.out.println("-------------------------------------");
        }
        else
            System.out.println("La lista de clientes de la base de datos esta vacia.");
    }
    public static Cliente idToCliente(int id){
        for(Cliente cliente : ClienteDAO.getAll()){
            if(cliente.getID() == id) return cliente;
        }
        return null;
    }
    public static void delCliente(){
        System.out.println("Introduce el ID del cliente que quieres eliminar.");
        int id = scanner.nextInt();

        Cliente toDelete = idToCliente(id);
        if(toDelete != null) ClienteDAO.delete(toDelete);
        else
            System.out.println("No hay ningun cliente con ese ID en la base de datos.");
    }
    public static void editCliente(){
        System.out.println("Introduce el ID del cliente que quieres editar.");
        int id = scanner.nextInt();

        if(idToCliente(id) != null)
            idToCliente(id).actualizarDatos();
        else
            System.out.println("El ID introducido no corresponde a ningun cliente. Volviendo al menu de clientes...");
    }
    public static void describeCliente(){
        System.out.println("Introduce el ID del cliente cuya informacion quieres ver.");
        int id = scanner.nextInt();

        if(idToCliente(id) != null)
            idToCliente(id).details();
        else
            System.out.println("El ID introducido no corresponde a ningun cliente. Volviendo al menu de clientes...");
    }

    public static void showAllMarcas(){
        ArrayList<Marca> lista_marca = MarcaDAO.getAll();
        if(!lista_marca.isEmpty()){
            System.out.println("-------------------------------------");
            MarcaView.quickGeneralView(lista_marca);
            System.out.println("-------------------------------------");
        }
        else
            System.out.println("La lista de marcas de la base de datos esta vacia.");
    }
    public static void newMarca(){
        System.out.println("Introduce el nombre que quieres darle a tu nueva marca.");
        String name = scanner.nextLine();

        MarcaDAO.insert(new Marca(name));
    }
    public static void delMarca(){
        System.out.println("Introduce el ID de la marca que quieres eliminar.");
        int id = scanner.nextInt();

        Marca toDelete = idToMarca(id);
        if(toDelete != null) MarcaDAO.delete(toDelete);
        else
            System.out.println("No hay ninguna marca con ese ID en la base de datos.");
    }
    public static Marca idToMarca(int id){
        for(Marca marca : MarcaDAO.getAll()){
            if(marca.getId() == id) return marca;
        }
        return null;
    }

    public static TipoVehiculo idToTipoVehiculo(int id){
        for(TipoVehiculo tipoVehiculo : TipoVehiculoDAO.getAll()){
            if(tipoVehiculo.getId() == id) return tipoVehiculo;
        }
        return null;
    }
    public static void showAllTiposVehiculos(){
        ArrayList<TipoVehiculo> lista_tipoVehiculo = TipoVehiculoDAO.getAll();
        if(!lista_tipoVehiculo.isEmpty()){
            System.out.println("-------------------------------------");
            TipoVehiculoView.quickGeneralView(lista_tipoVehiculo);
            System.out.println("-------------------------------------");
        }
        else
            System.out.println("La lista de tipos de vehiculos de la base de datos esta vacia.");
    }
    public static void newTipoVehiculo(){
        System.out.println("Introduce el nombre que quieres darle a tu nuevo tipo de vehiculo.");
        String name = scanner.nextLine();

        TipoVehiculoDAO.insert(new TipoVehiculo(name));
    }
    public static void delTipoVehiculo(){
        System.out.println("Introduce el ID del tipo de vehiculo que quieres eliminar.");
        int id = scanner.nextInt();

        TipoVehiculo toDelete = idToTipoVehiculo(id);
        if(toDelete != null) TipoVehiculoDAO.delete(toDelete);
        else
            System.out.println("No hay ningun tipo de vehiculo con ese ID en la base de datos.");
    }

    public static void showAllVehiculos(){
        ArrayList<Vehiculo> lista_vehiculos = VehiculoDAO.getAll();
        if(!lista_vehiculos.isEmpty()){
            System.out.println("-------------------------------------");
            VehiculoView.quickGeneralView(lista_vehiculos);
            System.out.println("-------------------------------------");
        }
        else
            System.out.println("La lista de vehiculos de la base de datos esta vacia.");
    }
    public static void newVehiculo(){
        System.out.println("Introduce el modelo del vehiculo.");
        String model = scanner.nextLine();

        System.out.println("Introduce el año del vehiculo.");
        int year = scanner.nextInt();

        System.out.println("Introduce la matricula del vehiculo.");
        String license_plate = scanner.next();

        System.out.println("Estas son las marcas disponibles: ");
        showAllMarcas();
        Marca marca;
        do { 
            System.out.println("Introduce el ID de la marca del vehiculo.");
            marca = idToMarca(scanner.nextInt());
            if (marca == null) {
                System.out.println("El ID introducido no es correcto, prueba de nuevo.");
            } else {
                System.out.println("Marca seleccionada: " + marca.getName());
            }
        } while (marca == null);
        

        System.out.println("Estos son los tipos de vehiculo disponibles: ");
        showAllTiposVehiculos();
        TipoVehiculo tipoVehiculo;
        do { 
            System.out.println("Introduce el ID del tipo del vehiculo.");
            tipoVehiculo = idToTipoVehiculo(scanner.nextInt());
            if (tipoVehiculo == null) {
                System.out.println("El ID introducido no es correcto, prueba de nuevo.");
            } else {
                System.out.println("Tipo de vehiculo seleccionado: " + marca.getName());
            }
        } while (tipoVehiculo == null);

        VehiculoDAO.insert(new Vehiculo(model, year, license_plate, marca.getId(), tipoVehiculo.getId()));
    }
    public static void delVehiculo(){
        System.out.println("Introduce el ID del vehiculo que quieres eliminar.");
        int id = scanner.nextInt();

        Vehiculo toDelete = idToVehiculo(id);
        if(toDelete != null) VehiculoDAO.delete(toDelete);
        else
            System.out.println("No hay ningun vehiculo con ese ID en la base de datos.");
    }
    public static Vehiculo idToVehiculo(int id){
        for(Vehiculo vehiculo : VehiculoDAO.getAll()){
            if(vehiculo.getId() == id) return vehiculo;
        }
        return null;
    }
    public static void linkVehiculoToCliente(){
        System.out.println("Estos son los vehiculos disponibles: ");
        showAllVehiculos();

        Vehiculo toLink;
        System.out.println("Introduce el ID del vehiculo que quieres vincular a un cliente.");
        do { 
            toLink = idToVehiculo(scanner.nextInt());
            if (toLink == null) {
                System.out.println("El ID introducido no es correcto, prueba de nuevo.");
            } else {
                System.out.println("Vehiculo seleccionado: " + toLink.getLicense_plate());
            }
        } while (toLink == null);

        System.out.println("Estos son los clientes disponibles: ");
        showAllClientes();

        Cliente owner;
        System.out.println("Introduce el ID del cliente al que quieres vincular el vehiculo.");
        do { 
            owner = idToCliente(scanner.nextInt());
            if (owner == null) {
                System.out.println("El ID introducido no es correcto, prueba de nuevo.");
            } else {
                System.out.println("Cliente seleccionado: " + owner.getName());
            }
        } while (owner == null);

        VehiculoDAO.actualizarOwner(toLink, owner);
    }
    public static void describeVehiculo(){
        System.out.println("Introduce el ID del vehiculo cuya informacion quieres ver.");
        Vehiculo toDescribe;
        do { 
            toDescribe = idToVehiculo(scanner.nextInt());
                if (toDescribe != null) {
                    System.out.println("Vehiculo seleccionado, mostrando detalles...");
                    toDescribe.details();
                }
                else
                    System.out.println("El ID introducido no corresponde a ningun vehiculo. Vuelve a intentarlo.");
        } while (toDescribe == null);
    }

    public static Servicio idToServicio(int id){
        for(Servicio servicio : ServicioDAO.getAll()){
            if(servicio.getId() == id) return servicio;
        }
        return null;
    }
    public static void showAllServicios(){
        ArrayList<Servicio> lista_servicios = ServicioDAO.getAll();
        if(!lista_servicios.isEmpty()){
            System.out.println("-------------------------------------");
            ServicioView.quickGeneralView(lista_servicios);
            System.out.println("-------------------------------------");
        }
        else
            System.out.println("La lista de servicios de la base de datos esta vacia.");
    }
    public static void newServicio(){
        System.out.println("Introduce el nombre que quieres darle a tu nuevo servicio.");
        String name = scanner.nextLine();

        System.out.println("Introduce el precio de tu nuevo servicio.");
        Double precio = scanner.nextDouble();

        ServicioDAO.insert(new Servicio(name, precio));
    }
    public static void delServicio(){
        System.out.println("Introduce el ID del servicio que quieres eliminar.");
        int id = scanner.nextInt();

        Servicio toDelete = idToServicio(id);
        if(toDelete != null) ServicioDAO.delete(toDelete);
        else
            System.out.println("No hay ningun servicio con ese ID en la base de datos.");
    }

    public static void showCitasPendientes(){
        ArrayList<Cita> lista_citas = CitaDAO.getAll();
        if(!lista_citas.isEmpty()){
            System.out.println("-------------------------------------");
            CitaView.showNoRealizados(lista_citas);
            System.out.println("-------------------------------------");
        }
        else
            System.out.println("La lista de citas de la base de datos esta vacia.");
    }
    public static void showCitasRealizadas(){
        ArrayList<Cita> lista_citas = CitaDAO.getAll();
        if(!lista_citas.isEmpty()){
            System.out.println("-------------------------------------");
            CitaView.showRealizados(lista_citas);
            System.out.println("-------------------------------------");
        }
        else
            System.out.println("La lista de citas de la base de datos esta vacia.");
    }
    public static void showAllCitas(){
        ArrayList<Cita> lista_citas = CitaDAO.getAll();
        if(!lista_citas.isEmpty()){
            System.out.println("-------------------------------------");
            CitaView.quickGeneralView(lista_citas);
            System.out.println("-------------------------------------");
        }
        else
            System.out.println("La lista de citas de la base de datos esta vacia.");
    }
    public static void newCita(){
        System.out.println("Introduce el ID del vehiculo al que quieres asignar una cita.");
        Vehiculo vehiculo;
        do { 
            vehiculo = idToVehiculo(scanner.nextInt());
            if (vehiculo != null) {
                System.out.println("Vehiculo seleccionado: " + vehiculo.getLicense_plate());
            } else {
                System.out.println("El ID introducido no es correcto, prueba de nuevo.");
            }
        } while (vehiculo == null);

        System.out.println("Introduce la fecha de la cita (Formato: YYYY-MM-DD)");
        String fecha = scanner.next();

        System.out.println("Introduce la hora de la cita (Formato: HH:MM)");
        String hora = scanner.next();

        System.out.println("Estos son los servicios disponibles: ");
        showAllServicios();
        Servicio servicio;
        do { 
            System.out.println("Introduce el ID del servicio que quieres asignar a la cita.");
            servicio = idToServicio(scanner.nextInt());
            if (servicio == null) {
                System.out.println("El ID introducido no es correcto, prueba de nuevo.");
            } else {
                System.out.println("Servicio seleccionado: " + servicio.getName());
            }
        } while (servicio == null);

        CitaDAO.insert(new Cita(vehiculo.getId(),servicio.getId(), fecha, hora));
    }
    public static void delCita(){
        System.out.println("Introduce el ID de la cita que quieres eliminar.");
        int id = scanner.nextInt();

        Cita toDelete = idToCita(id);
        if(toDelete != null) CitaDAO.delete(toDelete);
        else
            System.out.println("No hay ninguna cita con ese ID en la base de datos.");
    }
    public static Cita idToCita(int id){
        for(Cita cita : CitaDAO.getAll()){
            if(cita.getId() == id) return cita;
        }
        return null;
    }
    public static void changeCitaStatus(){
        System.out.println("Introduce el ID de la cita que quieres cambiar.");
        int id = scanner.nextInt();

        Cita toChange = idToCita(id);
        if(toChange != null) {
            //Parte del dinero
            CitaDAO.changeState(toChange);
        }
        else
            System.out.println("No hay ninguna cita con ese ID en la base de datos.");
    }

    public static void showAllProveedores(){
        ArrayList<Proveedor> lista_proveedores = ProveedorDAO.getAll();
        if(!lista_proveedores.isEmpty()){
            System.out.println("-------------------------------------");
            ProveedorView.quickGeneralView(lista_proveedores);
            System.out.println("-------------------------------------");
        }
        else
            System.out.println("La lista de proveedores de la base de datos esta vacia.");
    }
    public static void newProveedor(){
        System.out.println("Introduce el nombre que quieres darle a tu nuevo proveedor.");
        String name = scanner.nextLine();

        System.out.println("Introduce su correo electronico.");
        String mail = scanner.next();


        ProveedorDAO.insert(new Proveedor(name, mail));
    }
    public static void delProveedor(){
        System.out.println("Introduce el ID del proveedor que quieres eliminar.");
        int id = scanner.nextInt();

        Proveedor toDelete = idToProveedor(id);
        if(toDelete != null) ProveedorDAO.delete(toDelete);
        else
            System.out.println("No hay ningun proveedor con ese ID en la base de datos.");
    }
    public static Proveedor idToProveedor(int id){
        for(Proveedor proveedor : ProveedorDAO.getAll()){
            if(proveedor.getId() == id) return proveedor;
        }
        return null;
    }
    
    public static void showAllObjetos(){
        ArrayList<Objeto> lista_objetos = ObjetoDAO.getAll();
        if(!lista_objetos.isEmpty()){
            System.out.println("Estos son los objetos disponibles: ");
            System.out.println("-------------------------------------");
            ObjetoView.quickGeneralView(lista_objetos);
            System.out.println("-------------------------------------");
        }
        else
            System.out.println("La lista de objetos de la base de datos esta vacia.");
    }
    public static void newObjeto(){
        System.out.println("Introduce el nombre que quieres darle a tu nuevo objeto.");
        String name = scanner.nextLine();

        ObjetoDAO.insert(new Objeto(name));
        InventarioDAO.insert(new Inventario(ObjetoDAO.getLastId(), 0));
    }
    public static void delObjeto(){
        System.out.println("Introduce el ID del objeto que quieres eliminar.");
        int id = scanner.nextInt();

        Objeto toDelete = idToObjeto(id);
        if(toDelete != null){
            ObjetoDAO.delete(toDelete);
            InventarioDAO.delete(idToInventario(id));
        }
        else
            System.out.println("No hay ningun objeto con ese ID en la base de datos.");
    }
    public static Objeto idToObjeto(int id){
        for(Objeto objeto : ObjetoDAO.getAll()){
            if(objeto.getId() == id) return objeto;
        }
        return null;
    }
    
    public static Inventario idToInventario(int id) {
        for(Inventario inventario : InventarioDAO.getInventario()){
            if(inventario.getId_objeto() == id) return inventario;
        }
        return null;
    }
    public static void showCurrentInventario(){
        ArrayList<Inventario> lista_inventario = InventarioDAO.getInventario();
        if(!lista_inventario.isEmpty()){
            System.out.println("Estos son los objetos en el inventario y su cantidad: ");
            System.out.println("-------------------------------------");
            InventarioView.showInventarioNot0(lista_inventario);
            System.out.println("-------------------------------------");
        }
        else
            System.out.println("La lista de inventario de la base de datos esta vacia.");
    }
    public static void showAllInventario(){
        ArrayList<Inventario> lista_inventario = InventarioDAO.getInventario();
        if(!lista_inventario.isEmpty()){
            System.out.println("Estos son los objetos en el inventario y su cantidad: ");
            System.out.println("-------------------------------------");
            InventarioView.showAllInventario(lista_inventario);
            System.out.println("-------------------------------------");
        }
        else
            System.out.println("La lista de inventario de la base de datos esta vacia.");
    }
    public static void cambiarCantidadInventario(){
        System.out.println("Estos son los objetos del inventario cuya capacidad puedes cambiar:");
        showAllInventario();
        Inventario toChange;
        do{
            System.out.println("Introduce el ID del objeto cuya cantidad quieres cambiar.");
            toChange = idToInventario(scanner.nextInt());
            if(toChange != null){
                System.out.println("Objeto seleccionado: " + idToObjeto(toChange.getId_objeto()).getNombre());
                System.out.println("Cantidad actual: " + toChange.getCantidad());
            }
            else
                System.out.println("El ID introducido no corresponde a ningun objeto. Vuelve a intentarlo.");
        }while(toChange == null);


        int newQuantity;
        do{
            System.out.println("Introduce la nueva cantidad del objeto.");
            newQuantity = scanner.nextInt();
            if(newQuantity < 0) System.out.println("La cantidad no puede ser negativa, prueba de nuevo.");
    }while(newQuantity < 0);

        InventarioDAO.changeQuantity(toChange, newQuantity);
    }
    public static void sumarCantidadInventario(){
        System.out.println("Estos son los objetos del inventario a los que sumar o restar cantidad:");
        showAllInventario();
        Inventario toChange;
        do{
            System.out.println("Introduce el ID del objeto cuya cantidad quieres cambiar.");
            toChange = idToInventario(scanner.nextInt());
            if(toChange != null){
                System.out.println("Objeto seleccionado: " + idToObjeto(toChange.getId_objeto()).getNombre());
                System.out.println("Cantidad actual: " + toChange.getCantidad());
            }
            else
                System.out.println("El ID introducido no corresponde a ningun objeto. Vuelve a intentarlo.");
        }while(toChange == null);


        int sumando;
        
        System.out.println("Cuantas unidades quieres sumar? Introduce un numero negativo para restar.");
        sumando = scanner.nextInt();

        InventarioDAO.addQuantity(toChange, sumando);
    }

    public static void newPedido(){
        System.out.println("Estos son los proveedores disponibles:");
        showAllProveedores();
        Proveedor proveedor;
        do { 
            System.out.println("Introduce el ID del proveedor al que quieres hacer un pedido.");
            proveedor = idToProveedor(scanner.nextInt());
            if (proveedor != null) {
                System.out.println("Proveedor seleccionado: " + proveedor.getNombre());
            } else {
                System.out.println("El ID introducido no es correcto, prueba de nuevo.");
            }
        } while (proveedor == null);

        ArrayList<Inventario> contenido = new ArrayList<>();
        int id_objeto;
        int cantidad;
        boolean continuar = true;
        do{
            System.out.println("Estos son los objetos disponibles:");
            showAllObjetos();
            do{
                System.out.println("Introduce el ID del objeto que quieres añadir al pedido.");
                id_objeto = scanner.nextInt();
                if(idToObjeto(id_objeto) != null){
                    System.out.println("Objeto seleccionado: " + idToObjeto(id_objeto).getNombre());
                    System.out.println("Cuantas unidades quieres pedir?");
                    do{
                        cantidad = scanner.nextInt();
                        if(cantidad > 0){
                            contenido.add(new Inventario(id_objeto, cantidad));
                            System.out.println("Objeto añadido al pedido.");
                        }
                        else
                            System.out.println("La cantidad no puede ser negativa o cero, prueba de nuevo.");
                    }while(cantidad <= 0);
                }
                else
                    System.out.println("El ID introducido no corresponde a ningun objeto. Vuelve a intentarlo.");
            }while(idToObjeto(id_objeto) == null);
            System.out.println("Quieres añadir otro objeto al pedido? (1 - Si, 2 - No)");
            if(scanner.nextInt() != 1){
                continuar = false;
                System.out.println("OK. Creando el pedido...");
            }
        }while(continuar);

        PedidoDAO.insert(new Pedido(proveedor.getId(), contenido));
    }
    public static void showAllPedidos(){
        ArrayList<Pedido> lista_pedidos = PedidoDAO.getAll();
        if(!lista_pedidos.isEmpty()){
            System.out.println("Estos son los pedidos disponibles:");
            System.out.println("-------------------------------------");
            PedidoView.quickGeneralView(lista_pedidos);
            System.out.println("-------------------------------------");
        }
        else
            System.out.println("La lista de pedidos de la base de datos esta vacia.");
    }
    public static void showAllPedidosPendientes(){
        ArrayList<Pedido> lista_pedidos = PedidoDAO.getAll();
        if(!lista_pedidos.isEmpty()){
            System.out.println("Estos son los pedidos pendientes:");
            System.out.println("-------------------------------------");
            PedidoView.viewPendientes(lista_pedidos);
            System.out.println("-------------------------------------");
        }
        else
            System.out.println("La lista de pedidos de la base de datos esta vacia.");
    }
    public static void showAllPedidosCompletados(){
        ArrayList<Pedido> lista_pedidos = PedidoDAO.getAll();
        if(!lista_pedidos.isEmpty()){
            System.out.println("Estos son los pedidos completados:");
            System.out.println("-------------------------------------");
            PedidoView.viewCompletados(lista_pedidos);
            System.out.println("-------------------------------------");
        }
        else
            System.out.println("La lista de pedidos de la base de datos esta vacia.");
    }
    public static void delPedido(){
        System.out.println("Estos son los pedidos disponibles:");
        showAllPedidos();
        System.out.println("AVISO: No se recomienda eliminar pedidos sin tener cuidado, ya que estos influyen en el inventario y la contabilidad.");
        System.out.println("Introduce el ID del pedido que quieres eliminar.");
        int id = scanner.nextInt();

        Pedido toDelete = idToPedido(id);
        if(toDelete != null){
            if(toDelete.isCompleated()){
                System.out.println("El pedido que desea eliminar ya esta completado, por lo que es posible que sus objetos se hayan sumado al inventario. Quiere restar los objetos automaticamente del inventario (Esto no los reducira por debajo de 0)? (1 - Si, 2 - No)");
                if(scanner.nextInt() == 1){
                    for(Inventario inventario : toDelete.getContenido()){
                        InventarioDAO.addQuantity(inventario, -inventario.getCantidad());
                    }
                }
            }
            PedidoDAO.delete(toDelete);
            System.out.println("Pedido eliminado.");
        }
        else
            System.out.println("No hay ningun pedido con ese ID en la base de datos.");
    }
    public static Pedido idToPedido(int id){
        for(Pedido pedido : PedidoDAO.getAll()){
            if(pedido.getId() == id) return pedido;
        }
        return null;
    }
    public static void changePedidoState(){
        System.out.println("Estos son los pedidos disponibles:");
        showAllPedidos();
        System.out.println("Introduce el ID del pedido cuyo estado quieres cambiar.");
        int id = scanner.nextInt();

        Pedido toChange = idToPedido(id);
        if(toChange == null) 
            System.out.println("No hay ningun pedido con ese ID en la base de datos.");
        
        else if(toChange.isCompleated()){
            System.out.println("El pedido seleccionado esta completado, quieres cambiarlo a pendiente? (1 - Si, 2 - No)");
            if(scanner.nextInt() != 1)
                System.out.println("OK. El pedido no ha sido alterado.");
            else{
                System.out.println("Al cambiar un pedido a pendiente, puedes decidir si quieres restar los objetos del inventario automaticamente. Esto no reducira su cantidad por debajo de 0 (1 - Si, 2 - No)");
                if(scanner.nextInt() != 1)
                    System.out.println("OK. El inventario no ha sido alterado.");
                    else{
                        InventarioDAO.autoRemoveCantidadesPedido(toChange);
                    }
                PedidoDAO.changeState(toChange);
                System.out.println("Pedido cambiado a pendiente.");
            }
            
            
        }
        else{
            System.out.println("El pedido seleccionado esta pendiente, quieres cambiarlo a completado? (1 - Si, 2 - No)");
            if(scanner.nextInt() != 1)
                System.out.println("OK. El pedido no ha sido alterado.");
            else{
                System.out.println("Al cambiar un pedido a completado, puedes decidir si quieres sumar los objetos al inventario automaticamente.(1 - Si, 2 - No)");
                if(scanner.nextInt() != 1)
                    System.out.println("OK. El inventario no ha sido alterado.");
                    else{
                        InventarioDAO.addCantidadesPedido(toChange);
                    }
                PedidoDAO.changeState(toChange);
                System.out.println("Pedido cambiado a completado.");
            }
        }
    }
    public static void describePedido(){
        System.out.println("Introduce el ID del pedido cuya informacion quieres ver.");
        int id = scanner.nextInt();

        if(idToPedido(id) != null)
            idToPedido(id).details();
        else
            System.out.println("El ID introducido no corresponde a ningun pedido. Volviendo al menu de pedidos...");
    }

    public static void showAllTiposTransaccion(){
        ArrayList<TipoTransaccion> lista_tiposTransaccion = TipoTransaccionDAO.getAll();
        if(!lista_tiposTransaccion.isEmpty()){
            System.out.println("Estos son los tipos de transacciones disponibles:");
            System.out.println("-------------------------------------");
            TipoTransaccionView.quickGeneralView(lista_tiposTransaccion);
            System.out.println("-------------------------------------");
        }
        else
            System.out.println("La lista de tipos de transacciones de la base de datos esta vacia.");
    }
    public static void newTipoTransaccion(){
        System.out.println("Introduce el nombre del nuevo tipo de transaccion.");
        String name = scanner.nextLine();
        TipoTransaccion toInsert = new TipoTransaccion(name);
        TipoTransaccionDAO.insert(toInsert);
        System.out.println("Tipo de transaccion añadido a la base de datos.");
    }
    public static void delTipoTransaccion(){
        showAllTiposTransaccion();
        System.out.println("Introduce el ID del tipo de transaccion que quieres eliminar.");
        int id = scanner.nextInt();
        TipoTransaccion toDelete = idToTipoTransaccion(id);
        if(toDelete != null) {
            TipoTransaccionDAO.delete(toDelete);
            System.out.println("Tipo de transaccion eliminado.");
        }
        else
            System.out.println("No hay ningun tipo de transaccion con ese ID en la base de datos.");
    }
    public static TipoTransaccion idToTipoTransaccion(int id){
        for(TipoTransaccion tipoTransaccion : TipoTransaccionDAO.getAll()){
            if(tipoTransaccion.getId() == id) return tipoTransaccion;
        }
        return null;
    }
}