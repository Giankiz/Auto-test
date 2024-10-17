describe('Recruitment Process', () => {
  before(() => {
      cy.visit('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login');
  });

  it('should log in and add a candidate', () => {
      // Iniciar sesión
      cy.get('input[name="username"]').type('Admin'); // Cambiar según las credenciales
      cy.get('input[name="password"]').type('admin123'); // Cambiar según las credenciales
      cy.get('button[type="submit"]').click();

      // Navegar a Recruitment
      cy.get(':nth-child(5) > .oxd-main-menu-item').click();

      // Agregar un nuevo candidato
      cy.get('.orangehrm-header-container > .oxd-button').click();

      // Completar el formulario del candidato (ajusta según lo que necesites)
      cy.get('.--name-grouped-field > :nth-child(1) > :nth-child(2) > .oxd-input').type('Juan'); // First name
      cy.get(':nth-child(2) > :nth-child(2) > .oxd-input').type('Carlo');                                        // middle name
      cy.get(':nth-child(3) > :nth-child(2) > .oxd-input').type('Pérez');     // last name


      //listbox

      // Abre el dropdown
      cy.get('.oxd-select-text-input').click(); // Selecciona el texto del dropdown para abrirlo

      // Selecciona una opción específica (ej. Option 2)
      cy.get('.oxd-select-dropdown').contains('Senior QA Lead').click(); 

      // Verificar que la opción seleccionada esté visible en el dropdown
      cy.get('.oxd-select-text-input').should('contain', 'Senior QA Lead'); 
    

      cy.get(':nth-child(3) > .oxd-grid-3 > :nth-child(1) > .oxd-input-group > :nth-child(2) > .oxd-input').type('example_123@outlook.com'); // email 
      cy.get('.oxd-grid-3 > :nth-child(2) > .oxd-input-group > :nth-child(2) > .oxd-input').type('+50766668471');  //number
      cy.get('.orangehrm-save-candidate-page-full-width > .oxd-input-group > :nth-child(2) > .oxd-input').type('New member');  // keywords
      cy.get('.oxd-textarea').type('This is the record of the new employee'); // notes
      //seleccionar y verificar el checkbox
      cy.get('.oxd-checkbox-input').click();
      cy.get('[type="checkbox"]').check();
      cy.get('input[type="checkbox"]').should('be.checked');

      
      // subir docu
       // Selecciona el input de archivo y usa `attachFile`
       const fileName = 'example.txt'; // Nombre del archivo en fixtures
       cy.get('input.oxd-file-input').attachFile(fileName); // Asegúrate de que el selector sea correcto

       // Verificar que el archivo se haya subido correctamente
      
       //cy.contains('File uploaded successfully'); // se ajusta al mensaje configurado en la app   ( como no  sube el archivo no envia ningun mensaje asi que tuve que comentar este comando tambien)

       // O verificar si el archivo aparece en una lista o como un elemento
       //cy.get('.uploaded-file-list').should('contain', 'example.txt'); // no puedo usar esto porque el navegador no esta subiendo el archivo.

       // Abre el datepicker
       cy.get('.oxd-date-input > .oxd-input').click(); // Cambia al selector de tu datepicker

       // Selecciona la fecha deseada, por ejemplo, el 17 de octubre de 2024
       cy.get('.oxd-date-input-calendar')
           .contains('14').click(); // Asegúrate de que el selector corresponda a tu datepicker

       // Verificar que la fecha se haya establecido correctamente
       cy.get('.oxd-date-input > .oxd-input').should('have.value', '2024-14-10'); // Cambia el formato según sea necesario
      

      // Enviar el formulario
     cy.get('button[type="submit"]').click();
      
      // Verificar que el candidato fue agregado correctamente
     cy.contains('Successfully Saved');
  });
});