window.addEventListener('load', function () {
  const formulario = document.querySelector('#update_paciente_form');
  formulario.addEventListener('submit', function (event) {

    let pacienteId = document.querySelector('#paciente_id').value;

    const formData = {
      id: document.querySelector('#paciente_id').value,
      nombre: document.querySelector('#nombre').value,
      apellido: document.querySelector('#apellido').value,
      dni: document.querySelector('#dni').value,
      fechaIngreso: document.querySelector('#fechaIngreso').value,
      domicilio: {
       id: document.querySelector('#domicilio').value
     }
    };

    const url = '/paciente/actualizar';
    const settings = {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData)
    }
        fetch(url,settings)
          .then(response => response.json())

    })
 })

function findBy(id) {
  const url = '/paciente/buscar/' + id;
  const settings = {
    method: 'GET'
  };

  fetch(url, settings)
    .then(response => response.json())
    .then(data => {
      const paciente = data;
      document.querySelector('#paciente_id').value = paciente.id;
      document.querySelector('#nombre').value = paciente.nombre;
      document.querySelector('#apellido').value = paciente.apellido;
      document.querySelector('#dni').value = paciente.dni;
      document.querySelector('#fechaIngreso').value = paciente.fechaIngreso;
      document.querySelector('#domicilio').value = paciente.domicilio.id;

      document.querySelector('#div_paciente_updating').style.display = 'block';
    })
    .catch(error => {
      alert('Error: ' + error);
    });
}
