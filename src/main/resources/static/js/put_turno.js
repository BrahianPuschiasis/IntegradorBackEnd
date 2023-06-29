function findBy(id) {
  const url = '/turno/buscar/' + id;
  const settings = {
    method: 'GET'
  };

  fetch(url, settings)
    .then(response => response.json())
    .then(data => {
      let turno = data;
      document.querySelector('#turno_id').value = turno.id;
      document.querySelector('#odontologo').value = turno.odontologo.id;
      document.querySelector('#paciente').value = turno.paciente.id;
      document.querySelector('#fechaHora').value = turno.fechaHora;

      document.querySelector('#div_turno_updating').style.display = 'block';
    })
    .catch(error => {
      alert('Error: ' + error);
    });
}

window.addEventListener('load', function () {
  const formulario = document.querySelector('#update_turno_form');
  formulario.addEventListener('submit', function (event) {

    let turnoId = document.querySelector('#turno_id').value;

    const formData = {
      id: document.querySelector('#turno_id').value,
      odontologo: {
        id: document.querySelector('#odontologo').value
      },
      paciente: {
        id: document.querySelector('#paciente').value
      },
      fechaHora: document.querySelector('#fechaHora').value
    };

    const url = '/turno/actualizar';
    const settings = {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData)
    };

    fetch(url, settings)
      .then(response => response.json());
  });
});
