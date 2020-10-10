
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

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
            System.out.println(ListaEmpresas);

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
            System.out.println(ListacontratoArriendos);

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
        String fechadeInicio = (String) atributos.get("ciudad");
        String dechadeFin = (String) atributos.get("ciudad");
        int canon = Integer.parseInt((String) atributos.get("numContrato"));
        Sucursal empresa = (Sucursal) atributos.get("empresa");

        ContratoArriendo ContratoArriendoaLeida = new ContratoArriendo(codigo,fechadeInicio, dechadeFin,canon, empresa);
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
        int codigo = Integer.parseInt((String) atributos.get("codigoScursal"));
        String ciudad = (String) atributos.get("ciudad");
        String direccion = (String) atributos.get("direccion");
        int codigoSucursal = Integer.parseInt((String) atributos.get("cantEmpleados"));
        String empresa = (String) atributos.get("empresa");

        // NECESITO VOLVER A CONSTRUR LAS LISTAS CON CLASES DENTRO DE ELLAS*****
        Empresa empresass = null;
        for (Empresa empresa1 : empresasLeidas) {
            if(empresa1.Nit.equals(empresa) ){
                empresass = empresa1;
                break;
            }
        }


        Sucursal SucursalaLeida = new Sucursal(codigoSucursal,ciudad,direccion,codigo, empresass);
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





}
