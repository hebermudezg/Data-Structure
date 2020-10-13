import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.util.LinkedList;

// Escribir json que solo escribe usuaios************************************
public class EscribirJSON {
    public static String ruta = "src/main/resources/database/";

    // Funcion para guardar usuarios
    public static void guardarUsuario(LinkedList<Usuario> usuarios) {
        JSONArray UsuarioLista = new JSONArray();
        for (Usuario usuario : usuarios) {
            JSONObject UsuarioDatos = new JSONObject();
            UsuarioDatos.put("documento", String.valueOf(usuario.documento));
            UsuarioDatos.put("nombre", usuario.nombre);
            UsuarioDatos.put("apellido", usuario.apellido);
            UsuarioDatos.put("correo", usuario.correo);
            UsuarioDatos.put("contraseña", usuario.contraseña);
            JSONObject UsuarioPerfil = new JSONObject();
            UsuarioPerfil.put("Usuario", UsuarioDatos); //Esrbiendo el usuario
            UsuarioLista.add(UsuarioPerfil);
        }

        try (FileWriter file = new FileWriter(ruta+"UsuariosJSON.json")) {
            file.write(UsuarioLista.toJSONString());
            file.flush();
        } catch (Exception e){
            System.out.println("Error en: "+e);
        }
    }

    // Funcion para guardar empresas*******************************************************
    public static void guardarEmpresa(LinkedList<Empresa> empresas) {
        JSONArray EmpresaLista = new JSONArray();
        for (Empresa empresa : empresas) {
            JSONObject EmpresaDatos = new JSONObject();
            EmpresaDatos.put("Nit", empresa.Nit);
            EmpresaDatos.put("RazonSocial", empresa.RazonSocial);
            EmpresaDatos.put("Presidente", empresa.Presidente);
            JSONObject EmpresaPerfil = new JSONObject();
            EmpresaPerfil.put("Empresa", EmpresaDatos); //Esrbiendo el usuario
            EmpresaLista.add(EmpresaPerfil);
        }

        try (FileWriter file = new FileWriter(ruta+"EmpresasJSON.json")) {
            file.write(EmpresaLista.toJSONString());
            file.flush();
        } catch (Exception e){
            System.out.println("Error en: "+e);
        }
    }



   // Funcion para guardar contratosarriendo*********************************************************************
    public static void guardarContratoArriendo(LinkedList<ContratoArriendo> contratoarriendos) {
        JSONArray ContratoArriendoLista = new JSONArray();
        for (ContratoArriendo contratoarriendo : contratoarriendos) {
            JSONObject ContratoArriendoDatos = new JSONObject();
            ContratoArriendoDatos.put("numContrato", String.valueOf(contratoarriendo.numContrato));
            ContratoArriendoDatos.put("fechadeInicio", contratoarriendo.fechadeInicio);
            ContratoArriendoDatos.put("FechadeFin", contratoarriendo.FechadeFin);
            ContratoArriendoDatos.put("canon", String.valueOf(contratoarriendo.canon));

            ContratoArriendoDatos.put("sucursal", String.valueOf(contratoarriendo.sucursal.codigoScursal));

            JSONObject SucursalPerfil = new JSONObject();
            SucursalPerfil.put("ContratoArriendo", ContratoArriendoDatos); //Esrbiendo el usuario
            ContratoArriendoLista.add(SucursalPerfil);
        }

        try (FileWriter file = new FileWriter(ruta+"contratoArriendosJSON.json")) {
            file.write(ContratoArriendoLista.toJSONString());
            file.flush();
        } catch (Exception e){
            System.out.println("Error en: "+e);
        }
    }


    // Funcion para guardar sucursal*********************************************************************
    public static void guardarSucursal(LinkedList<Sucursal> sucursales) {
        JSONArray SucursalLista = new JSONArray();
        for (Sucursal Sucursal : sucursales) {
            JSONObject SucursalDatos = new JSONObject();
            SucursalDatos.put("codigoScursal", String.valueOf(Sucursal.codigoScursal));
            SucursalDatos.put("ciudad", Sucursal.ciudad);
            SucursalDatos.put("direccion", Sucursal.direccion);
            SucursalDatos.put("cantEmpleados", String.valueOf(Sucursal.cantEmpleados));
            SucursalDatos.put("empresa", Sucursal.empresa.Nit);


            JSONObject SucursalPerfil = new JSONObject();
            SucursalPerfil.put("Sucursal", SucursalDatos); //Esrbiendo el usuario
            SucursalLista.add(SucursalPerfil);
        }

        try (FileWriter file = new FileWriter(ruta+"sucursalesJSON.json")) {
            file.write(SucursalLista.toJSONString());
            file.flush();
        } catch (Exception e){
            System.out.println("Error en: "+e);
        }
    }


    // Funcion para guardar especialidad*********************************************************************
    public static void guardarEspecialida(LinkedList<Especialidad> especialidades) {
        JSONArray EspeciallidadLista = new JSONArray();
        for (Especialidad especialidad : especialidades) {
            JSONObject EspecialidadDatos = new JSONObject();
            EspecialidadDatos.put("codigoEspecialidad", String.valueOf(especialidad.codigoEspecialidad));
            EspecialidadDatos.put("encargado", especialidad.encargado);
            EspecialidadDatos.put("enfoque", especialidad.enfoque);
            EspecialidadDatos.put("lineaAtencion", String.valueOf(especialidad.lineaAtencion));

            EspecialidadDatos.put("sucursal", String.valueOf(especialidad.sucursal.codigoScursal)); // guardando el identificador unico


            JSONObject EspecialidadPerfil = new JSONObject();
            EspecialidadPerfil.put("Especialidad", EspecialidadDatos); //Esrbiendo el usuario
            EspeciallidadLista.add(EspecialidadPerfil);
        }

        try (FileWriter file = new FileWriter(ruta+"especialidadesJSON.json")) {
            file.write(EspeciallidadLista.toJSONString());
            file.flush();
        } catch (Exception e){
            System.out.println("Error en: "+e);
        }
    }




    // Funcion para guardar Tipo de entrega*********************************************************************
    public static void guardarTipoDeEntrega(LinkedList<TipoDeEntrega> tipodeentregas) {
        JSONArray TipoDeEntregaLista = new JSONArray();
        for (TipoDeEntrega tipoentrega : tipodeentregas) {
            JSONObject TipoDeEntregaDatos = new JSONObject();
            TipoDeEntregaDatos.put("Codigo", String.valueOf(tipoentrega.Codigo));
            TipoDeEntregaDatos.put("Tiempo_Estimado",  String.valueOf(tipoentrega.Tiempo_Estimado));
            TipoDeEntregaDatos.put("MedioDeTransporte", tipoentrega.MedioDeTransporte);


            JSONObject TipoDeEntregaPerfil = new JSONObject();
            TipoDeEntregaPerfil.put("TipoDeEntrega", TipoDeEntregaDatos); //Esrbiendo el usuario
            TipoDeEntregaLista.add(TipoDeEntregaPerfil);
        }

        try (FileWriter file = new FileWriter(ruta+"TipoDeEntregaJSON.json")) {
            file.write(TipoDeEntregaLista.toJSONString());
            file.flush();
        } catch (Exception e){
            System.out.println("Error en: "+e);
        }
    }


    // Funcion para guardar Clientes*********************************************************************
    public static void guardarCliente(LinkedList<Cliente> clientes) {
        JSONArray ClienteLista = new JSONArray();
        for (Cliente cliente : clientes) {
            JSONObject ClienteDatos = new JSONObject();
            ClienteDatos.put("Documento", String.valueOf(cliente.Documento));
            ClienteDatos.put("Nombre",  cliente.Nombre);
            ClienteDatos.put("Direccion",  cliente.Direccion);
            ClienteDatos.put("Telefono",  String.valueOf(cliente.Telefono));
            ClienteDatos.put("CodigoPostal",  String.valueOf(cliente.CodigoPostal));


            JSONObject ClientePerfil = new JSONObject();
            ClientePerfil.put("Cliente", ClienteDatos); //Esrbiendo el usuario
            ClienteLista.add(ClientePerfil);
        }

        try (FileWriter file = new FileWriter(ruta+"ClienteJSON.json")) {
            file.write(ClienteLista.toJSONString());
            file.flush();
        } catch (Exception e){
            System.out.println("Error en: "+e);
        }
    }


    // Funcion para guardar contratosRepartidores*********************************************************************
    public static void guardarContratoRepartidor(LinkedList<ContratoRepartidor> contrarorepartidores) {
        JSONArray ContratoRepartidorLista = new JSONArray();
        for (ContratoRepartidor contratorepartidor : contrarorepartidores) {
            JSONObject ContratoRepartidorDatos = new JSONObject();
            ContratoRepartidorDatos.put("numerocontrato", String.valueOf(contratorepartidor.numerocontrato));
            ContratoRepartidorDatos.put("salario", String.valueOf(contratorepartidor.salario));
            ContratoRepartidorDatos.put("fechainicio", contratorepartidor.fechainicio);
            ContratoRepartidorDatos.put("fechafin", contratorepartidor.fechafin);

            ContratoRepartidorDatos.put("repartidor", String.valueOf(contratorepartidor.repartidor.Cedula));


            JSONObject ContratoRepartidorPerfil = new JSONObject();
            ContratoRepartidorPerfil.put("ContratoRepartidor", ContratoRepartidorDatos); //Esrbiendo el usuario
            ContratoRepartidorLista.add(ContratoRepartidorPerfil);
        }

        try (FileWriter file = new FileWriter(ruta+"ContratoRepartidorJSON.json")) {
            file.write(ContratoRepartidorLista.toJSONString());
            file.flush();
        } catch (Exception e){
            System.out.println("Error en: "+e);
        }
    }




    // Funcion para guardar Repartidores*********************************************************************
    public static void guardarRepartidor(LinkedList<Repartidor> repardores) {
        JSONArray RepartidorLista = new JSONArray();
        for (Repartidor repardor : repardores) {
            JSONObject RepartidorDatos = new JSONObject();
            RepartidorDatos.put("Cedula", String.valueOf(repardor.Cedula));
            RepartidorDatos.put("Nombre",  repardor.Nombre);
            RepartidorDatos.put("Edad", String.valueOf(repardor.Edad));
            RepartidorDatos.put("Num_Celular", String.valueOf(repardor.Num_Celular));
            RepartidorDatos.put("Tipo_Licencia",  repardor.Tipo_Licencia);
<<<<<<< HEAD

=======
            RepartidorDatos.put("Sueldo",  String.valueOf(repardor.Sueldo));
>>>>>>> ba688a478a63a3a378a9d89d17a60b3c16d4e538


            JSONObject RepartidorPerfil = new JSONObject();
            RepartidorPerfil.put("Repartidor", RepartidorDatos); //Esrbiendo el usuario
            RepartidorLista.add(RepartidorPerfil);
        }

        try (FileWriter file = new FileWriter(ruta+"RepartidorJSON.json")) {
            file.write(RepartidorLista.toJSONString());
            file.flush();
        } catch (Exception e){
            System.out.println("Error en: "+e);
        }
    }


    // Funcion para guardar Entrega*********************************************************************
    public static void guardarEntrega(LinkedList<Entrega> entregas) {
        JSONArray RepartidorLista = new JSONArray();
        for (Entrega entrega : entregas) {
            JSONObject EntregaDatos = new JSONObject();
            EntregaDatos.put("codEntrega", String.valueOf(entrega.codEntrega));
            EntregaDatos.put("peso", String.valueOf(entrega.peso));
            EntregaDatos.put("dimenciones", String.valueOf(entrega.dimenciones));
            EntregaDatos.put("fragil",  entrega.fragil);
            EntregaDatos.put("costo", String.valueOf(entrega.costo));
            EntregaDatos.put("estadoEntrega",  entrega.estadoEntrega);

            // Clases
            EntregaDatos.put("especialidad", String.valueOf(entrega.especialidad.codigoEspecialidad));
            EntregaDatos.put("tipoDeEntrega", String.valueOf(entrega.tipoDeEntrega.Codigo));;
            EntregaDatos.put("cliente", String.valueOf(entrega.cliente.Documento));
            EntregaDatos.put("repartidor", String.valueOf(entrega.repartidor.Cedula));
            // Tengo que recuperar estas clases para re construir el objeto



            JSONObject EntregaPerfil = new JSONObject();
            EntregaPerfil.put("Entrega", EntregaDatos); //Esrbiendo el usuario
            RepartidorLista.add(EntregaPerfil);
        }

        try (FileWriter file = new FileWriter(ruta+"EntregaJSON.json")) {
            file.write(RepartidorLista.toJSONString());
            file.flush();
        } catch (Exception e){
            System.out.println("Error en: "+e);
        }
    }




}

