DELIMITER ;
drop PROCEDURE if exists Actualizar_Dispositivo;
CREATE PROCEDURE Actualizar_Dispositivo(
IN des_dispositivo VARCHAR(30),
IN precio int,
int tipo VARCHAR(30)
)
BEGIN
UPDATE dispositivos set des_dispositivo=des_dispositivo,precio=precio,tipo=tipo where
end$$
DELIMITER ;

