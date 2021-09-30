const url = "http://localhost:8080/EasyParking/api/usuarios"

const contenedor = document.querySelector('tbody')
let resultados = ''

const modalUsuarios = new bootstrap.Modal(document.getElementById('modalUsuario'))
const formUsuarios = document.querySelector('form')
const nombreUsuario = document.getElementById('nombre')
const telefonoUsuario = document.getElementById('telefono')
const emailUsuario = document.getElementById('email')
const direccionUsuario = document.getElementById('direccion')
const rolUsuario = document.getElementById('rol')
const userUsuario = document.getElementById('user')
const passwordUsuario = document.getElementById('password')
const idUsuario = document.getElementById('id')

let option = ''

btnCrear.addEventListener('click', () => {

    nombreUsuario.value = ''
    telefonoUsuario.value = ''
    emailUsuario.value = ''
    direccionUsuario.value = ''
    rolUsuario.value = ''
    userUsuario.value = ''
    passwordUsuario.value = ''
    idUsuario.value = ''
    idUsuario.disabled = false
    modalUsuarios.show()
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

            res.forEach((usuarios) => {
                resultados += `<tr>
                        <td width="5%" style="font-size: 14px; vertical-align: middle">${usuarios.id_usuario}</td>
                        <td style="font-size: 14px; vertical-align: middle">${usuarios.nombre_usu}</td>
                        <td style="font-size: 14px; vertical-align: middle">${usuarios.telefono_usu}</td>
                        <td style="font-size: 14px; vertical-align: middle">${usuarios.email_usu}</td>
                        <td style="font-size: 14px; vertical-align: middle">${usuarios.direccion_usu}</td>
                        <td style="font-size: 14px; vertical-align: middle">${usuarios.id_rol}</td>
                        <td style="font-size: 14px; vertical-align: middle">${usuarios.user}</td>
                        <td style="font-size: 14px; vertical-align: middle">${usuarios.password}</td>
                        <td width="10%" class="text-center" width="15%" style="font-size: 14px; vertical-align: middle">
                            <a class="btnEditar btn btn-primary" style="margin-right: 8px" >
                                <i class="fas fa-user-edit"></i>
                            </a>
                            <a class="btnBorrar btn btn-danger">
                                <i class="fas fa-user-minus"></i>
                            </a>    
                        </td>
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
        alertify.confirm(`¿Estás seguro de eliminar el id ${id}?`,
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
        idUsuario.value = fila.children[0].innerHTML
        nombreUsuario.value = fila.children[1].innerHTML
        telefonoUsuario.value = fila.children[2].innerHTML
        emailUsuario.value = fila.children[3].innerHTML
        direccionUsuario.value = fila.children[4].innerHTML
        rolUsuario.value = fila.children[5].innerHTML
        userUsuario.value = fila.children[6].innerHTML
        passwordUsuario.value = fila.children[7].innerHTML
        idUsuario.disabled = true
        opcion = 'editar'
        modalUsuarios.show()
    }
})

formUsuarios.addEventListener('submit', (e) => {
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
            "direccion_usu": direccionUsuario.value,
            "email_usu": emailUsuario.value,
            "id_rol": rolUsuario.value,
            "id_usuario": idUsuario.value,
            "nombre_usu": nombreUsuario.value,
            "password": passwordUsuario.value,
            "telefono_usu": telefonoUsuario.value,
            "user": userUsuario.value
        },
    });
    modalUsuarios.hide()
})

