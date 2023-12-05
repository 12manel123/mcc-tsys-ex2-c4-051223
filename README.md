RF1.Registrarse:
POST -> https://mcc-tsys-ex2-c4-051223-production.up.railway.app/ex2/register
Example:
{
  "username": "usuario2",
  "password": "contrasena123",
  "email": "usuario1@example.com"
}

RF2.Loguearse:
POST -> https://mcc-tsys-ex2-c4-051223-production.up.railway.app/ex2/login
Example:
{
  "username": "usuario2",
  "password": "contrasena123",
  "email": "usuario1@example.com"
}

RF3.Crear Partida:
POST -> https://mcc-tsys-ex2-c4-051223-production.up.railway.app/ex2/partida
Example:
{
  "nombre": "NombreDeLaPartida",
  "descripcion": "Descripción de la partida",
  "jugadores": 0,
  "plataforma": "Plataforma de juego",
  "fechaInicio": "2023-12-05T12:00:00",
  "videojuego": "NombreDelVideojuego"
}

RF4.BuscarPartidasPorVideojuego:
GET -> https://mcc-tsys-ex2-c4-051223-production.up.railway.app/ex2/partida/NombreDelVideojuego

RF5.Unirse A partida:
POST -> https://mcc-tsys-ex2-c4-051223-production.up.railway.app/ex2/partida/NombreDeLaPartida/unirse?nombreUsuario=usuario2

RF5.Salir Partida
POST -> https://mcc-tsys-ex2-c4-051223-production.up.railway.app/ex2/partida/NombreDeLaPartida/salir

RF6.Crear mensage:
POST -> https://mcc-tsys-ex2-c4-051223-production.up.railway.app/ex2/mensaje/crear
Example:
{
    "contenido": "Hola, ¿quién quiere unirse a la partida?",
    "nombreUsuarioCreador": "NombreUsuario",
    "partida": {
  "nombre": "NombreDeLaPartida",
  "descripcion": "Descripción de la partida",
  "jugadores": 0,
  "plataforma": "Plataforma de juego",
  "fechaInicio": "2023-12-05T12:00:00",
  "videojuego": "NombreDelVideojuego"
}

}

RF6.EliminarMensage:
DELETE -> https://mcc-tsys-ex2-c4-051223-production.up.railway.app/ex2/mensaje/eliminar/1

RF6.Editar Mensage:
PUT -> https://mcc-tsys-ex2-c4-051223-production.up.railway.app/ex2/mensaje/editar/1
Example:
{
    "contenido": "Hola, ¿quién quiere unirse a la nueva partida?",
    "nombreUsuarioCreador": "NombreUsuario",
    "partida": {
  "nombre": "NombreDeLaPartida",
  "descripcion": "Descripción de la partida",
  "jugadores": 0,
  "plataforma": "Plataforma de juego",
  "fechaInicio": "2023-12-05T12:00:00",
  "videojuego": "NombreDelVideojuego"
}

}

RF7.Ver todos los mensages de partida
GET -> https://mcc-tsys-ex2-c4-051223-production.up.railway.app/ex2/mensaje/verTodosEnSala/NombreDeLaPartida

RF8.Actualizar perfil
POST -> https://mcc-tsys-ex2-c4-051223-production.up.railway.app/ex2/updateProfile
Example:
{
  "username": "usuario2",
  "password": "contrasena123",
  "email": "usuario1@example.com"
}


RF9.Cerrar sesión:
POST -> https://mcc-tsys-ex2-c4-051223-production.up.railway.app/ex2/logout/usuario2
