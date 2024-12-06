
  #language: es

  @HistoriaDeUsuario
  Característica: Añadir un nuevo candidato en la funcionalidad Recruitment

    Yo como usuario administrador, quiero añadir un nuevo candidato en la funcionalidad Recruitment de la pagina opensource-demo.orangehrmlive.com


  @CasoAñadirCandidato
    Escenario: Añadir un nuevo candidato

    Dado que el usuario acceda a la pagina orangehrmlive.com
    Y utilice el rol administrador para iniciar sesión
      |usuario|contraseña|
      |Admin  |admin123  |

    Cuando el usuario ingrese al módulo Recruitment y de click en el boton Add
    Y complete los campos requeridos y haga click en el botón guardar
      |nombre     |segundo_nombre|apellido|vacante    |email      |numero_de_contacto |palabras_clave    |fecha_de_aplicacion  |notas|
      |Juan|Carlos       |Perez      |Senior QA Lead|mail@example.com|61626465|Introvert, Focused|2024-23-04|esta es una aplicacion para la nueva avacante|
    Entonces se valida la existencia del nuevo candidato

