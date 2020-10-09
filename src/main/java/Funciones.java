public static void VEmpresa(){
        Iterator<Empresa> iterador = empresas.listIterator();
        while (iterador.hasNext()) {
        Empresa empresa = iterador.next();
        System.out.println(empresa);
        }
        }
public static void CEmpresa(){
        System.out.println("ingrese el nit de la nueva empresa: ");
        int nit=input.nextInt();
        if(nit<0){
        System.out.println("el nit ingresado es invalido, seras regresado al menu anterior");
        return;
        }
        //en caso de necesitar iterador
        //for (Empresa ){
        //    if(personaPendiente.cedula == cedula) {
        //        System.out.println("Ya existe una persona con esta cedula");
        //        return;
        //    }
        System.out.println("ingrese la razon social de la empresa: ");
        String razon=input.nextLine();
        System.out.println("ingrese el presidente de la empresa: ");
        String presidente = input.nextLine();

        Empresa nuevaEmpresa = new Empresa(nit,razon,presidente);
        empresas.add(nuevaEmpresa);
        System.out.println("Empresa ingresada");

        }
public static void EEmpresa(){
        System.out.println("ingrese el nit de la empresa a modificar: ");
        int nit = input.nextInt();
        Iterator<Empresa> iterator = empresas.listIterator();
        while (iterator.hasNext()){
        Empresa empresa = iterator.next();
        if (empresa.Nit==nit){
        System.out.println("Que deseas modificar: ");
        System.out.println("1. Nit ");
        System.out.println("2. Razon social ");
        System.out.println("3. Presidente ");
        String option;
        option = input.next();
        if (option.equals("1")) {
        System.out.println("ingrese el nuevo Nit:");
        int x = input.nextInt();
        if (x<0){
        System.out.println("Nit invalido, seras regresado al menu anterior");
        return;
        }
        empresa.Nit=x;
        System.out.println("Nit modificado satisfactoriamente");
        }else if (option.equals("2")) {
        System.out.println("ingrese la nueva razon social:");
        String x = input.nextLine();
        empresa.RazonSocial=x;
        System.out.println("Razon social modificada satisfactoriamente");
        }else if (option.equals("3")) {
        System.out.println("ingrese el nuevo Presidente:");
        String x = input.nextLine();
        empresa.Presidente = x;
        System.out.println("Presidente modificado satisfactoriamente");
        break;
        }
        }
        }
        }
public static void ELEmpresa(){
        System.out.println("ingrese el nit de la empresa a modificar: ");
        int nit = input.nextInt();
        Iterator<Empresa> iterator = empresas.listIterator();
        while (iterator.hasNext()){
        Empresa empresa = iterator.next();
        if (empresa.Nit==nit){
        //COMO SE ELIMINA EL OBJETO DE LA ARRAYLIST?
        }
        }
        }

public static void VSucursal() {
        Iterator<Sucursal> iterador = sucursales.listIterator();
        while (iterador.hasNext()) {
        Sucursal sucursal = iterador.next();
        System.out.println(sucursal);
        }
        }

public static void CSucursal() {
        System.out.println("ingrese el Codigo de la nueva sucursal: ");
        int x=input.nextInt();
        if(x<0){
        System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
        return;
        }
        System.out.println("ingrese la Ciudad de la sucursal: ");
        String y=input.nextLine();
        System.out.println("ingrese la direccion de la sucursal: ");
        String z = input.nextLine();
        System.out.println("ingrese la cantidad de empleados de la nueva sucursal: ");
        int w=input.nextInt();
        if(w<0){
        System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
        return;
        }

        Sucursal sucursal = new Sucursal(x,y,z,w);
        sucursales.add(sucursal);
        System.out.println("Sucusal ingresada");
        }

public static void ESucursal() {
        System.out.println("ingrese el codigo de la sucursal a modificar: ");
        int n = input.nextInt();
        Iterator<Sucursal> iterador = sucursales.listIterator();
        while (iterador.hasNext()) {
        Sucursal sucursal = iterador.next();
        if (sucursal.Codigo==n){
        System.out.println("Que deseas modificar: ");
        System.out.println("1. Codigo ");
        System.out.println("2. Ciudad ");
        System.out.println("3. Direccion ");
        System.out.println("4. Cantidad de empleados ");
        String option;
        option = input.next();
        if (option.equals("1")) {
        System.out.println("ingrese el nuevo Codigo:");
        int x = input.nextInt();
        if (x<0){
        System.out.println("Numero invalido, seras regresado al menu anterior");
        return;
        }
        sucursal.Codigo=x;
        System.out.println("Codigo modificado satisfactoriamente");
        }else if (option.equals("2")) {
        System.out.println("ingrese la nueva ciudad:");
        String x = input.nextLine();
        sucursal.Ciudad=x;
        System.out.println("Razon social modificada satisfactoriamente");
        }else if (option.equals("3")) {
        System.out.println("ingrese la nueva direccion:");
        String x = input.nextLine();
        sucursal.Direccion = x;
        System.out.println("Direccion modificada satisfactoriamente");
        }else if (option.equals("4")) {
        System.out.println("ingrese la nueva cantidad de empleados");
        int x = input.nextInt();
        if (x<0){
        System.out.println("Numero invalido, seras regresado al menu anterior");
        return;
        }
        sucursal.Codigo=x;
        System.out.println("Cantidad de empleados modificado satisfactoriamente");
        break;
        }
        }
        }
        }

public static void ELSucursal() {
        System.out.println("ingrese el Codigo de la sucursal a eliminar: ");
        int x = input.nextInt();
        Iterator<Sucursal> iterador = sucursales.listIterator();
        while (iterador.hasNext()) {
        Sucursal sucursal = iterador.next();
        if (sucursal.Codigo==x){
        //COMO SE ELIMINA EL OBJETO DE LA ARRAYLIST?
        }
        }
        }

public static void VEspecialidad() {
        Iterator<Especialidad> iterador = especialidades.listIterator();
        while (iterador.hasNext()) {
        Especialidad especialidad = iterador.next();
        System.out.println(especialidad);
        }
        }

public static void CEspecialidad() {
        System.out.println("ingrese el Codigo de la nueva especialidad: ");
        int x=input.nextInt();
        if(x<0){
        System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
        return;
        }
        System.out.println("ingrese la Encargado de la especialidad: ");
        String y=input.nextLine();
        System.out.println("ingrese la Enfoque de la especialidad: ");
        String z = input.nextLine();
        System.out.println("ingrese la Linea de atencion de la especialidad: ");
        int w=input.nextInt();
        if(w<0){
        System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
        return;
        }

        Especialidad especialidad = new Especialidad(x,y,z,w);
        especialidades.add(especialidad);
        System.out.println("Especialidad ingresada");
        }

public static void EEspecialidad() {
        System.out.println("ingrese el codigo de la especialidad a modificar: ");
        int n = input.nextInt();
        Iterator<Especialidad> iterador = especialidades.listIterator();
        while (iterador.hasNext()) {
        Especialidad especialidad = iterador.next();
        if (especialidad.Codigo==n){
        System.out.println("Que deseas modificar: ");
        System.out.println("1. Codigo ");
        System.out.println("2. Encargado ");
        System.out.println("3. Enfoque ");
        System.out.println("4. Linea de atencion ");
        String option;
        option = input.next();
        if (option.equals("1")) {
        System.out.println("ingrese el nuevo Codigo:");
        int x = input.nextInt();
        if (x<0){
        System.out.println("Numero invalido, seras regresado al menu anterior");
        return;
        }
        especialidad.Codigo=x;
        System.out.println("Codigo modificado satisfactoriamente");
        }else if (option.equals("2")) {
        System.out.println("ingrese nuevo encargado:");
        String x = input.nextLine();
        especialidad.Encargado=x;
        System.out.println("Encargado modificada satisfactoriamente");
        }else if (option.equals("3")) {
        System.out.println("ingrese nuevo enfoque:");
        String x = input.nextLine();
        especialidad.Enfoque = x;
        System.out.println("Enfoque modificada satisfactoriamente");
        }else if (option.equals("4")) {
        System.out.println("ingrese nueva linea de atencion");
        int x = input.nextInt();
        if (x<0){
        System.out.println("Numero invalido, seras regresado al menu anterior");
        return;
        }
        especialidad.Linea_Atencion=x;
        System.out.println("Linea de atencion modificado satisfactoriamente");
        break;
        }
        }
        }
        }

public static void ELEspecialidad() {
        System.out.println("ingrese el codigo de la especialidad a modificar: ");
        int nit = input.nextInt();
        Iterator<Especialidad> iterador = especialidades.listIterator();
        while (iterador.hasNext()) {
        Especialidad especialidad = iterador.next();
        if (especialidad.Codigo==nit){
        //COMO SE ELIMINA EL OBJETO DE LA ARRAYLIST?
        }
        }
        }

public static void VContratoArriendo() {
        Iterator<ContratoArriendo> iterador = contratoArriendos.listIterator();
        while (iterador.hasNext()) {
        ContratoArriendo contratoArriendo = iterador.next();
        System.out.println(contratoArriendo);
        }
        }

public static void CContratoArriendo() {
        System.out.println("ingrese el numero de contrato de arriendo nuevo: ");
        int x=input.nextInt();
        if(x<0){
        System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
        return;
        }
        System.out.println("ingrese la fecha de inicio del contrato de arriendo: ");
        int y=input.nextInt();
        if(x<0){
        System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
        return;
        }
        System.out.println("ingrese la fecha de fin del contrato de arriendo: ");
        int z=input.nextInt();
        if(x<0){
        System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
        return;
        }
        System.out.println("ingrese el canon del contrato de arriendo: ");
        int w=input.nextInt();
        if(w<0){
        System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
        return;
        }

        ContratoArriendo contratoArriendo = new ContratoArriendo(x,y,z,w);
        contratoArriendos.add(contratoArriendo);
        System.out.println("Contrato de arriendo ingresada");
        }

public static void EContratoArriendo() {
        System.out.println("ingrese el numero del contrato a modificar: ");
        int nit = input.nextInt();
        Iterator<ContratoArriendo> iterador = contratoArriendos.listIterator();
        while (iterador.hasNext()) {
        ContratoArriendo contratoArriendo = iterador.next();
        if (contratoArriendo.Numcontrato == nit) {
        System.out.println("Que deseas modificar: ");
        System.out.println("1. Numero de contrato ");
        System.out.println("2. Fecha de inicio ");
        System.out.println("3. Fecha de fin ");
        System.out.println("4. canon ");
        String option;
        option = input.next();
        if (option.equals("1")) {
        System.out.println("ingrese el nuevo numero de contrato:");
        int x = input.nextInt();
        if (x < 0) {
        System.out.println("Numero invalido, seras regresado al menu anterior");
        return;
        }
        contratoArriendo.Numcontrato = x;
        System.out.println("Numero de contrato modificado satisfactoriamente");
        }else if (option.equals("2")) {
        System.out.println("ingrese nueva fecha de inicio");
        int x = input.nextInt();
        if (x<0){
        System.out.println("Numero invalido, seras regresado al menu anterior");
        return;
        }
        contratoArriendo.FechaDeInicio=x;
        System.out.println("Fecha de inicio modificado satisfactoriamente");

        }else if (option.equals("3")) {
        System.out.println("ingrese nueva Fecha de fin");
        int x = input.nextInt();
        if (x < 0) {
        System.out.println("Numero invalido, seras regresado al menu anterior");
        return;
        }
        contratoArriendo.FechaDeFin = x;
        System.out.println("Fecha de fin modificado satisfactoriamente");
        }else if (option.equals("4")) {
        System.out.println("ingrese nueva canon");
        double x = input.nextInt();
        if (x<0){
        System.out.println("Numero invalido, seras regresado al menu anterior");
        return;
        }
        contratoArriendo.Canon=x;
        System.out.println("canon modificado satisfactoriamente");
        break;
        }
        }
        }
        }

public static void ELContratoArriendo() {
        System.out.println("ingrese el numero del contrato a modificar: ");
        int nit = input.nextInt();
        Iterator<ContratoArriendo> iterador = contratoArriendos.listIterator();
        while (iterador.hasNext()) {
        ContratoArriendo contratoArriendo = iterador.next();
        if (contratoArriendo.Numcontrato == nit) {
        //COMO SE ELIMINA EL OBJETO DE LA ARRAYLIST?
        }
        }
        }

public static void VRepartidor() {
        Iterator<Repartidor> iterador = repartidores.listIterator();
        while (iterador.hasNext()) {
        Repartidor repartidor = iterador.next();
        System.out.println(repartidor);
        }
        }

public static void CRepartidor() {
        System.out.println("ingrese la cedula del repartidor: ");
        int x=input.nextInt();
        if(x<0){
        System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
        return;
        }
        System.out.println("ingrese el nombre del repartidor: ");
        String y=input.nextLine();
        System.out.println("ingrese la edad del repartidor: ");
        int a=input.nextInt();
        if(a<0){
        System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
        return;
        }
        System.out.println("ingrese el numero celular del repartidor: ");
        int b=input.nextInt();
        if(b<0){
        System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
        return;
        }
        System.out.println("ingrese el tipo de licencia del repartidor: ");
        String z = input.nextLine();
        System.out.println("ingrese el sueldo del repartidor: ");
        double c=input.nextInt();
        if(c<0){
        System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
        return;
        }

        Repartidor repartidor = new Repartidor(x,y,a,b,z,c);
        repartidores.add(repartidor);
        System.out.println("Repartidor ingresado");
        }

public static void ERepartidor() {
        System.out.println("ingrese cedula del repartidor a modificar: ");
        int n = input.nextInt();
        Iterator<Repartidor> iterador = repartidores.listIterator();
        while (iterador.hasNext()) {
        Repartidor repartidor = iterador.next();
        if (repartidor.Cedula == n) {
        System.out.println("Que deseas modificar: ");
        System.out.println("1. Edad ");
        System.out.println("2. Numero de celular ");
        System.out.println("3. Tipo de licencia ");
        System.out.println("4. Sueldo ");
        String option;
        option = input.next();
        if (option.equals("1")) {
        System.out.println("ingrese nueva edad:");
        int x = input.nextInt();
        if (x < 0) {
        System.out.println("Numero invalido, seras regresado al menu anterior");
        return;
        }
        repartidor.Edad = x;
        System.out.println("Edad modificado satisfactoriamente");
        }else if (option.equals("2")) {
        System.out.println("ingrese nueva numero de celular");
        int x = input.nextInt();
        if (x<0){
        System.out.println("Numero invalido, seras regresado al menu anterior");
        return;
        }
        repartidor.Num_Celular=x;
        System.out.println("Numero celular modificado satisfactoriamente");

        }else if (option.equals("3")) {
        System.out.println("ingrese nuevo tipo de licencia:");
        String x = input.nextLine();
        repartidor.Tipo_Licencia=x;
        System.out.println("Tipo de licencia modificada satisfactoriamente");
        }else if (option.equals("4")) {
        System.out.println("ingrese nueva sueldo");
        double x = input.nextInt();
        if (x<0){
        System.out.println("Numero invalido, seras regresado al menu anterior");
        return;
        }
        repartidor.Sueldo=x;
        System.out.println("sueldo modificado satisfactoriamente");
        break;
        }
        }
        }
        }

public static void ELRepartidor() {
        System.out.println("ingrese cedula del repartidor a modificar: ");
        int x = input.nextInt();
        Iterator<Repartidor> iterador = repartidores.listIterator();
        while (iterador.hasNext()) {
        Repartidor repartidor = iterador.next();
        if (repartidor.Cedula == x) {
        //COMO SE ELIMINA EL OBJETO DE LA ARRAYLIST?
        }
        }
        }

public static void VTipoEntrega() {
        Iterator<TipoDeEntrega> iterador = tipoDeEntregas.listIterator();
        while (iterador.hasNext()) {
        TipoDeEntrega tipoDeEntrega = iterador.next();
        System.out.println(tipoDeEntrega);
        }
        }

public static void CTipoEntrega() {
        System.out.println("ingrese el Codigo del tipo de entrega: ");
        int x=input.nextInt();
        if(x<0){
        System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
        return;
        }
        System.out.println("ingrese el tiempo estimado del tipo de entrega: ");
        int w=input.nextInt();
        if(w<0){
        System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
        return;
        }
        System.out.println("ingrese medio de transporte del tipo de entrega: ");
        String y=input.nextLine();

        TipoDeEntrega tipoDeEntrega = new TipoDeEntrega(x,w,y);
        tipoDeEntregas.add(tipoDeEntrega);
        System.out.println("Tipo de entrega ingresada");
        }

public static void ETipoEntrega() {
        System.out.println("ingrese Codigo del tipo de entrega a modificar: ");
        int n = input.nextInt();
        Iterator<TipoDeEntrega> iterador = tipoDeEntregas.listIterator();
        while (iterador.hasNext()) {
        TipoDeEntrega tipoDeEntrega = iterador.next();
        if (tipoDeEntrega.Codigo == n) {
        System.out.println("Que deseas modificar: ");
        System.out.println("1. Tiempo estimado ");
        String option;
        option = input.next();
        if (option.equals("1")) {
        System.out.println("ingrese nueva Tiempo de entrega:");
        int x = input.nextInt();
        if (x < 0) {
        System.out.println("Numero invalido, seras regresado al menu anterior");
        return;
        }
        tipoDeEntrega.Tiempo_Estimado = x;
        System.out.println("Timepo de entrega modificado satisfactoriamente");

        break;
        }
        }
        }
        }

public static void ELTipoEntrega() {
        System.out.println("ingrese Codigo del tipo de entrega a modificar: ");
        int x = input.nextInt();
        Iterator<TipoDeEntrega> iterador = tipoDeEntregas.listIterator();
        while (iterador.hasNext()) {
        TipoDeEntrega tipoDeEntrega = iterador.next();
        if (tipoDeEntrega.Codigo == x) {
        //COMO SE ELIMINA EL OBJETO DE LA ARRAYLIST?
        }
        }
        }

public static void VEntrega() {
        Iterator<Entrega> iterador = entregas.listIterator();
        while (iterador.hasNext()) {
        Entrega entrega = iterador.next();
        System.out.println(entrega);
        }
        }

public static void CEntrega() {
        System.out.println("ingrese el Codigo de entrega: ");
        int a=input.nextInt();
        if(a<0){
        System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
        return;
        }
        System.out.println("ingrese el peso de entrega: ");
        double b=input.nextInt();
        if(b<0){
        System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
        return;
        }
        System.out.println("ingrese las dimenciones de entrega: ");
        int c=input.nextInt();
        if(c<0){
        System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
        return;
        }
        System.out.println("la entrega es fragil: ");
        System.out.println("1. Si");
        System.out.println("2. No");
        String option = input.nextLine();
        boolean w;
        if (option.equals("1")){
        w=true;
        }else if (option.equals("2")){
        w=false;
        }else{
        System.out.println("Opcion no valida");
        return;
        }
        System.out.println("ingrese el costo de entrega: ");
        double x=input.nextInt();
        if(x<0){
        System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
        return;
        }
        System.out.println("ingrese estado de la entrega: ");
        String y=input.nextLine();

        Entrega entrega = new Entrega(a,b,c,w,x,y);
        entregas.add(entrega);
        System.out.println("Entrega ingresada");
        }

public static void EEntrega() {
        System.out.println("ingrese Codigo de entrega a modificar: ");
        int n = input.nextInt();
        Iterator<Entrega> iterador = entregas.listIterator();
        while (iterador.hasNext()) {
        Entrega entrega = iterador.next();
        if (entrega.Cod_Entrega == n) {
        System.out.println("Que deseas modificar: ");
        System.out.println("1. Codigo ");
        String option;
        option = input.next();
        if (option.equals("1")) {
        System.out.println("ingrese nueva Codigo:");
        int x = input.nextInt();
        if (x < 0) {
        System.out.println("Numero invalido, seras regresado al menu anterior");
        return;
        }
        entrega.Cod_Entrega = x;
        System.out.println("Codigo modificado satisfactoriamente");
        break;
        }
        }
        }
        }

public static void ELEntrega() {
        System.out.println("ingrese Codigo de entrega a modificar: ");
        int x = input.nextInt();
        Iterator<Entrega> iterador = entregas.listIterator();
        while (iterador.hasNext()) {
        Entrega entrega = iterador.next();
        if (entrega.Cod_Entrega == x) {
        //COMO SE ELIMINA EL OBJETO DE LA ARRAYLIST?
        }
        }
        }

public static void VCliente() {
        Iterator<Cliente> iterador = clientes.listIterator();
        while (iterador.hasNext()) {
        Cliente cliente = iterador.next();
        System.out.println(cliente);
        }
        }

public static void CCliente() {
        System.out.println("ingrese el documento del cliente: ");
        int x=input.nextInt();
        if(x<0){
        System.out.println("el nit ingresado es invalido, seras regresado al menu anterior");
        return;
        }
        System.out.println("ingrese el nombre del cliente: ");
        String y=input.nextLine();
        System.out.println("ingrese la direccion del cliente: ");
        String z = input.nextLine();
        System.out.println("ingrese el telefono del cliente: ");
        int a=input.nextInt();
        if(a<0){
        System.out.println("el nit ingresado es invalido, seras regresado al menu anterior");
        return;
        }
        System.out.println("ingrese el codigo postal del cliente: ");
        int b=input.nextInt();
        if(b<0){
        System.out.println("el nit ingresado es invalido, seras regresado al menu anterior");
        return;
        }

        Cliente cliente = new Cliente(x,y,z,a,b);
        clientes.add(cliente);
        System.out.println("Cliente ingresada");
        }

public static void ECliente() {
        System.out.println("ingrese Documento del cliente a modificar: ");
        int n = input.nextInt();
        Iterator<Cliente> iterador = clientes.listIterator();
        while (iterador.hasNext()) {
        Cliente cliente = iterador.next();
        if (cliente.Documento == n) {
        System.out.println("Que deseas modificar: ");
        System.out.println("1. Direccion ");
        System.out.println("2. Telefono ");
        System.out.println("3. Codigo postal ");
        String option;
        option = input.next();
        if (option.equals("1")) {
        System.out.println("ingrese nuevo Direccion:");
        String x = input.nextLine();
        cliente.Direccion=x;
        System.out.println("Direccion modificada satisfactoriamente");
        }else if (option.equals("2")) {
        System.out.println("ingrese nueva telefono");
        int x = input.nextInt();
        if (x<0){
        System.out.println("Numero invalido, seras regresado al menu anterior");
        return;
        }
        cliente.Telefono=x;
        System.out.println("Telefono modificado satisfactoriamente");
        }else if (option.equals("3")) {
        System.out.println("ingrese nueva Codigo postal");
        int x = input.nextInt();
        if (x<0){
        System.out.println("Numero invalido, seras regresado al menu anterior");
        return;
        }
        cliente.CodigoPostal=x;
        System.out.println("Codigo postal modificado satisfactoriamente");
        break;
        }
        }
        }
        }

public static void ELCliente() {
        System.out.println("ingrese Documento del cliente a modificar: ");
        int x = input.nextInt();
        Iterator<Cliente> iterador = clientes.listIterator();
        while (iterador.hasNext()) {
        Cliente cliente = iterador.next();
        if (cliente.Documento == x) {
        //COMO SE ELIMINA EL OBJETO DE LA ARRAYLIST?
        }
        }
        }