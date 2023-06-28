window.addEventListener('load', function () {
  // Al cargar la página buscamos y obtenemos el formulario donde estarán
  // los datos que el usuario cargará del nuevo odontólogo
  const formulario = document.querySelector('#add_new_odontologo');

  // Ante un submit del formulario se ejecutará la siguiente función
  formulario.addEventListener('submit', function (event) {
    event.preventDefault(); // Prevenir el envío del formulario

    // Creamos un objeto que contendrá los datos del nuevo odontólogo
    const formData = {
      nombre: document.querySelector('#nombre').value,
      apellido: document.querySelector('#apellido').value,
      matricula: document.querySelector('#matricula').value,
    };

    // Invocamos la API odontólogos utilizando la función fetch con el método POST,
    // enviando los datos del odontólogo en formato JSON
    const url = 'http://localhost:8080/odontologo/guardar';
    const settings = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData),
    };

    fetch(url, settings)
      .then(response => response.json())
      .then(data => {
        // Si no hay ningún error, se muestra un mensaje diciendo que el odontólogo
        // se agregó correctamente
        let successAlert =
          '<div class="alert alert-success alert-dismissible">' +
          '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
          '<strong></strong> Odontólogo agregado </div>';

        document.querySelector('#response').innerHTML = successAlert;
        document.querySelector('#response').style.display = 'block';
        // Se dejan todos los campos vacíos por si se quiere ingresar otro odontólogo
        resetUploadForm();
      })
      .catch(error => {
        // Si hay algún error, se muestra un mensaje diciendo que el odontólogo
        // no se pudo guardar e intentarlo nuevamente
        let errorAlert =
          '<div class="alert alert-danger alert-dismissible">' +
          '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
          '<strong>Error, intente nuevamente</strong></div>';

        document.querySelector('#response').innerHTML = errorAlert;
        document.querySelector('#response').style.display = 'block';
        // Se dejan todos los campos vacíos por si se quiere ingresar otro odontólogo
        resetUploadForm();
      });
  });

  function resetUploadForm() {
    document.querySelector('#nombre').value = '';
    document.querySelector('#apellido').value = '';
    document.querySelector('#matricula').value = '';
  }

  (function () {
    let pathname = window.location.pathname;
    if (pathname === '/') {
      document.querySelector('.nav .nav-item a:first').classList.add('active');
    } else if (pathname == '/odontologoList.html') {
      document.querySelector('.nav .nav-item a:last').classList.add('active');
    }
  })();
});
