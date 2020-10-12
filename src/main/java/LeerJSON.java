
import java.awt.event.ComponentListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import com.sun.deploy.util.SessionState;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class LeerJSON {


    // Leer Usuarios *******************************************************
    public static LinkedList<Usuario> leerUsuariosJson(){
        LinkedList<Usuario> usuariosLeidos = new LinkedList<>();
        JSONParser jsonParser = new JSONParser(); //
        try (FileReader reader = new FileReader(EscribirJSON.ruta+"UsuariosJSON.json"))   {
            Object obj = jsonParser.parse(reader);
            JSONArray ListaUsuarios = (JSONArray)obj ;
            // Iprimiendo *****************************************
            System.out.println(ListaUsuarios);

            for(Object usuarioObjeto : ListaUsuarios){
                JSONObject usuarioJSON = (JSONObject) usuarioObjeto;
                usuariosLeidos.add(parseUsuario(usuarioJSON));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return usuariosLeidos;
    }

    private static Usuario parseUsuario(JSONObject usuarioJSON)
    {
        JSONObject atributos = (JSONObject) usuarioJSON.get("Usuario");

        int documento = Integer.parseInt((String) atributos.get("documento"));
        String nombre = (String) atributos.get("nombre");
        String apellido = (String) atributos.get("apellido");
        String correo = (String) atributos.get("correo");
        String contraseña = (String) atributos.get("contraseña");

        Usuario usuarioLeido = new Usuario(documento,nombre,apellido,correo,contraseña);
        return usuarioLeido;
    }


    // Leer Empresas************************************************************************************************
    public static LinkedList<Empresa> empresasLeidas = new LinkedList<>(); // tuve que poner esto aquí
    public static LinkedList<Empresa> leerEmpresasJson(){
        //LinkedList<Empresa> empresasLeidas = new LinkedList<>();
        JSONParser jsonParserempresa = new JSONParser(); //
        try (FileReader reader = new FileReader(EscribirJSON.ruta+"EmpresasJSON.json"))   {
            Object obj = jsonParserempresa.parse(reader);
            JSONArray ListaEmpresas = (JSONArray)obj ;
            // Iprimiendo *****************************************
            //System.out.println(ListaEmpresas);

            for(Object empresaObjeto : ListaEmpresas){
                JSONObject empresaJSON = (JSONObject) empresaObjeto;
                empresasLeidas.add(parseEmpresa(empresaJSON));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return empresasLeidas;
    }

    public static Empresa parseEmpresa(JSONObject empresaJSON)
    {
        JSONObject atributos = (JSONObject) empresaJSON.get("Empresa");
        String Nit = (String) atributos.get("Nit");
        String RazonSocial = (String) atributos.get("RazonSocial");
        String Presidente = (String) atributos.get("Presidente");

        Empresa empresaaLeida = new Empresa(Nit,RazonSocial,Presidente);
        return empresaaLeida;
    }


    // Leer contratoArriendos*****************************************************************************************
    public static LinkedList<ContratoArriendo> contratoArriendosLeidas = new LinkedList<>();
    public static LinkedList<ContratoArriendo> leercontratoArriendosJson(){
        //LinkedList<ContratoArriendo> contratoArriendosLeidas = new LinkedList<>();
        JSONParser jsonParserContratoArriendo = new JSONParser(); //
        try (FileReader reader = new FileReader(EscribirJSON.ruta+"contratoArriendosJSON.json"))   {
            Object obj = jsonParserContratoArriendo.parse(reader);
            JSONArray ListacontratoArriendos = (JSONArray)obj ;
            // Iprimiendo *****************************************
            //System.out.println(ListacontratoArriendos);

            for(Object ContratoArriendoObjeto : ListacontratoArriendos){
                JSONObject ContratoArriendoJSON = (JSONObject) ContratoArriendoObjeto;
                contratoArriendosLeidas.add(parseContratoArriendo(ContratoArriendoJSON));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return contratoArriendosLeidas;
    }

    private static ContratoArriendo parseContratoArriendo(JSONObject ContratoArriendoJSON)
    {
        JSONObject atributos = (JSONObject) ContratoArriendoJSON.get("ContratoArriendo");
        int codigo = Integer.parseInt((String) atributos.get("numContrato"));
        String fechadeInicio = (String) atributos.get("fechadeInicio");
        String dechadeFin = (String) atributos.get("FechadeFin");
        int canon = Integer.parseInt((String) atributos.get("canon"));
        Sucursal sucursal = (Sucursal) atributos.get("sucursal");

        ContratoArriendo ContratoArriendoaLeida = new ContratoArriendo(codigo,fechadeInicio, dechadeFin,canon, sucursal);
        return ContratoArriendoaLeida;
    }


    // Leer Sucursales************************************************************************************************
    public static LinkedList<Sucursal> SucursalesLeidas = new LinkedList<>();
    public static LinkedList<Sucursal> leerSucursalesJson(){
        //LinkedList<Sucursal> SucursalesLeidas = new LinkedList<>();
        JSONParser jsonParserSucursal = new JSONParser(); //
        try (FileReader reader = new FileReader(EscribirJSON.ruta+"SucursalesJSON.json"))   {
            Object obj = jsonParserSucursal.parse(reader);
            JSONArray ListaSucursales = (JSONArray)obj ;
            // Iprimiendo *****************************************
            //System.out.println(ListaSucursales);

            for(Object SucursalObjeto : ListaSucursales){
                JSONObject SucursalJSON = (JSONObject) SucursalObjeto;
                SucursalesLeidas.add(parseSucursal(SucursalJSON));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return SucursalesLeidas;
    }

    public static Sucursal parseSucursal(JSONObject SucursalJSON)
    {
        JSONObject atributos = (JSONObject) SucursalJSON.get("Sucursal");
        int codigoScursal = Integer.parseInt((String) atributos.get("codigoScursal"));
        String ciudad = (String) atributos.get("ciudad");
        String direccion = (String) atributos.get("direccion");
        int cantEmpleados = Integer.parseInt((String) atributos.get("cantEmpleados"));
        String empresa = (String) atributos.get("empresa");

        // NECESITO VOLVER A CONSTRUR LAS LISTAS CON CLASES DENTRO DE ELLAS*****
        Empresa empresass = null;
        for (Empresa empresa1 : empresasLeidas) {
            if(empresa1.Nit.equals(empresa) ){
                empresass = empresa1;
                break;
            }
        }


        Sucursal SucursalaLeida = new Sucursal(codigoScursal,ciudad,direccion,cantEmpleados, empresass);
        return SucursalaLeida;
    }


    // Leer especialidades*********************************************************************************************
    public static LinkedList<Especialidad> EspecialidadesLeidas = new LinkedList<>();
    public static LinkedList<Especialidad> leerEspecialidadesJson(){
        //LinkedList<Sucursal> SucursalesLeidas = new LinkedList<>();
        JSONParser jsonParserEspecialidad = new JSONParser(); //
        try (FileReader reader = new FileReader(EscribirJSON.ruta+"especialidadesJSON.json"))   {
            Object obj = jsonParserEspecialidad.parse(reader);
            JSONArray ListaEspecialidades = (JSONArray)obj ;
            // Iprimiendo *****************************************
            //System.out.println(ListaSucursales);

            for(Object EspecialidadObjeto : ListaEspecialidades){
                JSONObject EspecilidadJSON = (JSONObject) EspecialidadObjeto;
                EspecialidadesLeidas.add(parseEspecialidad(EspecilidadJSON));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return EspecialidadesLeidas;
    }

    public static Especialidad parseEspecialidad(JSONObject EspecialidadJSON)
    {
        JSONObject atributos = (JSONObject) EspecialidadJSON.get("Especialidad");
        int codigoEspecialidad = Integer.parseInt((String) atributos.get("codigoEspecialidad"));
        String encargado = (String) atributos.get("encargado");
        String enfoque = (String) atributos.get("enfoque");
        int lineaAtencion = Integer.parseInt((String) atributos.get("lineaAtencion"));
        int sucursal = Integer.parseInt((String) atributos.get("sucursal"));

        // NECESITO VOLVER A CONSTRUR LAS LISTAS CON CLASES DENTRO DE ELLAS*****
        Sucursal sucursales = null;
        for (Sucursal sucursal1 : SucursalesLeidas) {
            if(sucursal1.codigoScursal == sucursal ){
                sucursales = sucursal1;
                break;
            }
        }
        Especialidad EspecialidadLeida = new Especialidad(codigoEspecialidad,encargado,enfoque,lineaAtencion, sucursales);
        return EspecialidadLeida;
    }


    // Leer tipo de entrega*********************************************************************************************
    public static LinkedList<TipoDeEntrega> TipodeentregaLeidas = new LinkedList<>();
    public static LinkedList<TipoDeEntrega> leerTipoDeEntregaJson(){
        //LinkedList<Sucursal> SucursalesLeidas = new LinkedList<>();
        JSONParser jsonParserTipoDeEntrega = new JSONParser(); //
        try (FileReader reader = new FileReader(EscribirJSON.ruta+"TipoDeEntregaJSON.json"))   {
            Object obj = jsonParserTipoDeEntrega.parse(reader);
            JSONArray ListaTipoDeEntrega = (JSONArray)obj ;
            // Iprimiendo *****************************************
            //System.out.println(ListaSucursales);

            for(Object ListaTipoDeEntregaObjeto : ListaTipoDeEntrega){
                JSONObject TipoDeEntregaJSON = (JSONObject) ListaTipoDeEntregaObjeto;
                TipodeentregaLeidas.add(parseTipoDeEntrega(TipoDeEntregaJSON));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return TipodeentregaLeidas;
    }

    public static TipoDeEntrega parseTipoDeEntrega(JSONObject TipoDeEntregaJSON)
    {
        JSONObject atributos = (JSONObject) TipoDeEntregaJSON.get("TipoDeEntrega");

        int Codigo = Integer.parseInt((String) atributos.get("Codigo"));
        int Tiempo_Estimado = Integer.parseInt((String) atributos.get("Tiempo_Estimado"));
        String MedioDeTransporte = (String) atributos.get("MedioDeTransporte");


        TipoDeEntrega TipoDeEntregaLedas = new TipoDeEntrega(Codigo, Tiempo_Estimado, MedioDeTransporte);
        return TipoDeEntregaLedas;
    }



    // Leer Cliente*********************************************************************************************
    public static LinkedList<Cliente> ClientesLeidos = new LinkedList<>();
    public static LinkedList<Cliente> leerClienteJson(){
        //LinkedList<Sucursal> SucursalesLeidas = new LinkedList<>();
        JSONParser jsonParserCliente = new JSONParser(); //
        try (FileReader reader = new FileReader(EscribirJSON.ruta+"TipoDeEntregaJSON.json"))   {
            Object obj = jsonParserCliente.parse(reader);
            JSONArray ListaCliente = (JSONArray)obj ;
            // Iprimiendo *****************************************
            //System.out.println(ListaSucursales);

            for(Object ClienteObjeto : ListaCliente){
                JSONObject ClienteJSON = (JSONObject) ClienteObjeto;
                ClientesLeidos.add(parseCliente(ClienteJSON));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ClientesLeidos;
    }

    public static Cliente parseCliente(JSONObject ClienteJSON)
    {
        JSONObject atributos = (JSONObject) ClienteJSON.get("Cliente");

        int Documento = Integer.parseInt((String) atributos.get("Documento"));
        String Nombre = (String) atributos.get("Nombre");
        String Direccion = (String) atributos.get("Direccion");
        int Telefono = Integer.parseInt((String) atributos.get("Telefono"));
        int CodigoPostal = Integer.parseInt((String) atributos.get("CodigoPostal"));


        Cliente ClientesLeidos = new Cliente(Documento, Nombre, Direccion, Telefono, CodigoPostal);
        return ClientesLeidos;
    }




    // Leer Repartidor*********************************************************************************************
    public static LinkedList<Repartidor> RepartidorLeidos = new LinkedList<>();
    public static LinkedList<Repartidor> leerRepartidorJson(){
        JSONParser jsonParserRepartidor = new JSONParser(); //
        try (FileReader reader = new FileReader(EscribirJSON.ruta+"RepartidorJSON.json"))   {
            Object obj = jsonParserRepartidor.parse(reader);
            JSONArray ListaRepartidor = (JSONArray)obj ;
            // Iprimiendo *****************************************
            //System.out.println(ListaSucursales);

            for(Object RepartidorObjeto : ListaRepartidor){
                JSONObject RepartidorJSON = (JSONObject) RepartidorObjeto;
                RepartidorLeidos.add(parseRepartidor(RepartidorJSON));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return RepartidorLeidos;
    }

    public static Repartidor parseRepartidor(JSONObject ClienteJSON)
    {
        JSONObject atributos = (JSONObject) ClienteJSON.get("Repartidor");

        int Cedula = Integer.parseInt((String) atributos.get("Cedula"));
        String Nombre = (String) atributos.get("Nombre");
        int Edad = Integer.parseInt((String) atributos.get("Edad"));
        int Num_Celular = Integer.parseInt((String) atributos.get("Num_Celular"));
        String Tipo_Licencia = (String) atributos.get("Tipo_Licencia");
        double Sueldo = Integer.parseInt((String) atributos.get("Sueldo"));

        Repartidor RepartidorLeidos = new Repartidor(Cedula, Nombre, Edad, Num_Celular, Tipo_Licencia, Sueldo);
        return RepartidorLeidos;
    }






    // Leer contrato repartidor***************************************************************************************

    public static LinkedList<ContratoRepartidor> ContratoRepartidorLeidos = new LinkedList<>();
    public static LinkedList<ContratoRepartidor> leerContratoRepartidorJson(){
        JSONParser jsonParserContratoRepartidor = new JSONParser(); //
        try (FileReader reader = new FileReader(EscribirJSON.ruta+"ContratoRepartidorJSON.json"))   {
            Object obj = jsonParserContratoRepartidor.parse(reader);
            JSONArray ListaContratoRepartidor = (JSONArray)obj ;

            for(Object ContratoRepartidorObjeto : ListaContratoRepartidor){
                JSONObject ContratoRepartidorJSON = (JSONObject) ContratoRepartidorObjeto;
                ContratoRepartidorLeidos.add(parseContratoRepartidor(ContratoRepartidorJSON));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ContratoRepartidorLeidos;
    }

    public static ContratoRepartidor parseContratoRepartidor(JSONObject ClienteJSON)
    {
        JSONObject atributos = (JSONObject) ClienteJSON.get("Contrato Repartidor");

        int numerocontrato = Integer.parseInt((String) atributos.get("numerocontrato"));
        int salario = Integer.parseInt((String) atributos.get("salario"));
        String fechainicio = (String) atributos.get("fechainicio");
        String fechafin = (String) atributos.get("fechafin");

        int repartidor = Integer.parseInt((String) atributos.get("repartidor"));

        // NECESITO VOLVER A CONSTRUR LAS LISTAS CON CLASES DENTRO DE ELLAS*****
        Repartidor repartidores = null;
        for (Repartidor repartidor1 : RepartidorLeidos) {
            if(repartidor1.Cedula == repartidor ){
                repartidores = repartidor1;
                break;
            }
        }


        ContratoRepartidor contratoderepartidorleidos = new ContratoRepartidor(numerocontrato, salario, fechainicio, fechafin, repartidores);
        return contratoderepartidorleidos;
    }




    // Leer ENTREGA ***************************************************************************************

    public static LinkedList<Entrega> EntregaLeidos = new LinkedList<>();
    public static LinkedList<Entrega> leerEntregaJson(){
        JSONParser jsonParserEntrega = new JSONParser(); //
        try (FileReader reader = new FileReader(EscribirJSON.ruta+"EntregaJSON.json"))   {
            Object obj = jsonParserEntrega.parse(reader);
            JSONArray ListaEntrega = (JSONArray)obj ;

            for(Object EntregaObjeto : ListaEntrega){
                JSONObject EntregaJSON = (JSONObject) EntregaObjeto;
                EntregaLeidos.add(parseEntrega(EntregaJSON));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return EntregaLeidos;
    }

    public static Entrega parseEntrega(JSONObject EntregaJSON)
    {
        JSONObject atributos = (JSONObject) EntregaJSON.get("Entrega");

        int codEntrega = Integer.parseInt((String) atributos.get("codEntrega"));
        double peso = Double.parseDouble((String) atributos.get("peso"));
        int dimenciones = Integer.parseInt((String) atributos.get("dimenciones"));
        boolean fragil = (boolean) atributos.get("fragil");
        double costo = Double.parseDouble((String) atributos.get("costo"));
        String estadoEntrega = (String) atributos.get("estadoEntrega");

        int especialidad = Integer.parseInt((String) atributos.get("especialidad"));
        int tipoDeEntrega = Integer.parseInt((String) atributos.get("tipoDeEntrega"));
        int cliente = Integer.parseInt((String) atributos.get("cliente"));
        int repartidor = Integer.parseInt((String) atributos.get("repartidor"));


        // NECESITO VOLVER A CONSTRUR LAS LISTAS CON CLASES DENTRO DE ELLAS*****
        Especialidad especialidadd = null;
        for (Especialidad especialidad1 : EspecialidadesLeidas) {
            if(especialidad1.codigoEspecialidad == especialidad ){
                especialidadd = especialidad1;
                break;
            }
        }

        TipoDeEntrega tipoentregaa = null;
        for (TipoDeEntrega tipoentregaa1 : TipodeentregaLeidas) {
            if(tipoentregaa1.Codigo == tipoDeEntrega ){
                tipoentregaa = tipoentregaa1;
                break;
            }
        }

        Cliente clientess = null;
        for (Cliente cliente1 : ClientesLeidos) {
            if(cliente1.Documento == cliente ){
                clientess = cliente1;
                break;
            }
        }

        Repartidor repartidorr = null;
        for (Repartidor repartidor1 : RepartidorLeidos) {
            if(repartidor1.Cedula == repartidor){
                repartidorr = repartidor1;
                break;
            }
        }





        Entrega Entregaleidos = new Entrega(codEntrega, peso, dimenciones, fragil, costo, estadoEntrega, especialidadd,tipoentregaa, clientess, repartidorr);
        return Entregaleidos;
    }







}
