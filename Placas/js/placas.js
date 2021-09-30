const url = "http://localhost:8080/EasyParking/api/placas"
const contenedor = document.querySelector('tbody')
let resultados = ''

const modalPlacas = new bootstrap.Modal(document.getElementById('modalPlaca'))
const formPlacas = document.querySelector('form')
const numeroPlaca = document.getElementById('id')
const tipodeVehiculo = document.getElementById('tipoVehiculo')

let opcion = ''

btnCrear.addEventListener('click', () => {

    tipodeVehiculo.value = ''
    numeroPlaca.value = ''
    numeroPlaca.disabled = false
    modalPlacas.show()
    opcion = 'crear'
})

const ajax = (options) => {
    let { url, method, success, error, data } = options;
    const xhr = new XMLHttpRequest();

    xhr.addEventListener("readystatechange", (e) => {
        if (xhr.readyState !== 4) return;

        if (xhr.status >= 200 && xhr.status < 300) {
            let json = JSON.parse(xhr.responseText);
            success(json);
        } else {
            let message = xhr.statusText || "Ocurrió un error";
            error(`Error ${xhr.status}: ${message}`);
        }
    });

    xhr.open(method || "GET", url);
    xhr.setRequestHeader("Content-type", "application/json; charset=utf-8");
    xhr.send(JSON.stringify(data));
};

const getAll = () => {
    ajax({
        url: url,
        method: "GET",
        success: (res) => {
            console.log(res);

            res.forEach((placas) => {
                resultados += `<tr>
                        <td width="15%">${placas.id_vehiculo}</td>
                        <td width="25%">${placas.id_tipo_veh}</td>
                        <td class="text-center" width="20%"><a class="btnEditar btn btn-primary">Editar</a><a class="btnBorrar btn btn-danger">Borrar</a></td>
                    </tr>`
            });

            contenedor.innerHTML = resultados
        },
        error: (err) => {
            console.log(err);
            $table.insertAdjacentHTML("afterend", `<p><b>${err}</b></p>`);
        },
    });
};

document.addEventListener("DOMContentLoaded", getAll);

document.addEventListener("click", (e) => {

    if (e.target.matches(".btnBorrar")) {
        const fila = e.target.parentNode.parentNode
        const id = fila.firstElementChild.innerHTML
        console.log(id)
        alertify.confirm(`¿Estás seguro de eliminar la placa ${id}?`,
            function () {
                ajax({
                    url: url + "/" + id,
                    method: "DELETE",
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    success: (res) => location.reload(),
                    error: (err) => alert(err),
                });
                alertify.success('Registro eliminado')
            },
            function () {
                alertify.error('Cancel')
            });


    }
    if (e.target.matches(".btnEditar")) {
        const fila = e.target.parentNode.parentNode
        numeroPlaca.value = fila.children[0].innerHTML
        tipodeVehiculo.value = fila.children[1].innerHTML
        numeroPlaca.disabled = true
        opcion = 'editar'
        modalPlacas.show()
    }
})

formPlacas.addEventListener('submit', (e) => {
    e.preventDefault()
    let metodo = "POST"
    if (opcion == 'editar') {
        metodo = "PUT"
 
    }
    ajax({
        url: url,
        method: metodo,
        headers: {
            'Content-Type': 'application/json'
        },
        success: (res) => location.reload(),
        error: (err) =>
            $form.insertAdjacentHTML("afterend", `<p><b>${err}</b></p>`),
        data: {
            "id_vehiculo": numeroPlaca.value,
            "id_tipo_veh": tipodeVehiculo.value,
            
        },
    });
    modalPlacas.hide()
})

