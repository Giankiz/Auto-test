// Aplicación del Patrón Screenplay + Cucumber
// Estructura adaptada para el modelo y organización por tareas, interacciones y preguntas

describe('Recruitment Process', () => {
    before(() => {
        cy.visit('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login');
    });
  
    it('should log in and add a candidate', () => {
        // Actor inicia sesión
        Login.as('Admin', 'admin123');
  
        // Actor navega al módulo de Recruitment
        Navigate.to('Recruitment');
  
        // Actor realiza la tarea de agregar un candidato
        AddCandidate.withDetails({
            firstName: 'Juan',
            middleName: 'Carlo',
            lastName: 'Pérez',
            jobTitle: 'Senior QA Lead',
            email: 'example_123@outlook.com',
            contactNumber: '+50766668471',
            keywords: 'New member',
            notes: 'This is the record of the new employee',
            dateAvailable: '2024-10-14',
            resume: 'example.txt'
        });
  
        // Verificar resultado
        Verify.message('Successfully Saved');
    });
  });
  
  // Tareas del modelo Screenplay
  const Login = {
    as(username, password) {
        cy.get('input[name="username"]').type(username);
        cy.get('input[name="password"]').type(password);
        cy.get('button[type="submit"]').click();
    }
  };
  
  const Navigate = {
    to(moduleName) {
        const moduleMap = {
            'Recruitment': ':nth-child(5) > .oxd-main-menu-item'
        };
        cy.get(moduleMap[moduleName]).click();
    }
  };
  
  const AddCandidate = {
    withDetails(details) {
        cy.get('.orangehrm-header-container > .oxd-button').click();
        
        // Rellenar detalles
        cy.get('.--name-grouped-field > :nth-child(1) > :nth-child(2) > .oxd-input').type(details.firstName);
        cy.get(':nth-child(2) > :nth-child(2) > .oxd-input').type(details.middleName);
        cy.get(':nth-child(3) > :nth-child(2) > .oxd-input').type(details.lastName);
  
        // Seleccionar job title
        cy.get('.oxd-select-text-input').click();
        cy.get('.oxd-select-dropdown').contains(details.jobTitle).click();
        cy.get('.oxd-select-text-input').should('contain', details.jobTitle);
  
        // Otros campos
        cy.get(':nth-child(3) > .oxd-grid-3 > :nth-child(1) > .oxd-input-group > :nth-child(2) > .oxd-input').type(details.email);
        cy.get('.oxd-grid-3 > :nth-child(2) > .oxd-input-group > :nth-child(2) > .oxd-input').type(details.contactNumber);
        cy.get('.orangehrm-save-candidate-page-full-width > .oxd-input-group > :nth-child(2) > .oxd-input').type(details.keywords);
        cy.get('.oxd-textarea').type(details.notes);
  
        // Subir archivo
        cy.fixture(details.resume).then(fileContent => {
            cy.get('input.oxd-file-input').attachFile({ fileContent, fileName: details.resume, mimeType: 'text/plain' });
        });
  
        // Date validation: current date or earlier
        const currentDate = new Date().toISOString().split('T')[0]; // Format: YYYY-MM-DD
        if (new Date(details.dateAvailable) > new Date(currentDate)) {
          throw new Error('The selected date cannot be in the future.');
        }
        // Enviar formulario
        cy.get('button[type="submit"]').click();
    }
  };
  
  const Verify = {
    message(expectedMessage) {
        cy.contains(expectedMessage);
    }
  };
  