            formatter.setTimeZone(TimeZone.getTimeZone("UTC")); // Asegurar que se maneja la misma zona horaria

ALTER TABLE facturas MODIFY COLUMN Pendiente_de_pago DATE NULL;
