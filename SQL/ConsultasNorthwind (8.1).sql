USE Northwind

GO

/* 1. Nombre del pa�s y n�mero de clientes de cada pa�s, ordenados alfab�ticamente por el nombre del pa�s.*/

SELECT Country, (COUNT (CustomerID)) AS NumeroClientes
	FROM Customers 
	GROUP BY Country
	ORDER BY Country ASC

/* 2. ID de producto y n�mero de unidades vendidas de cada producto. */

SELECT ProductID, Quantity
	FROM [Order Details]

--	select UnitsOnOrder, UnitsInStock, QuantityPerUnit from products
/* 3. ID del cliente y n�mero de pedidos que nos ha hecho. */

SELECT CustomerID, (COUNT (OrderDate)) AS NumeroPedidos
	FROM Orders
	GROUP BY CustomerID

/* 4. ID del cliente, a�o y n�mero de pedidos que nos ha hecho cada a�o. */

SELECT CustomerID, OrderDate, (COUNT (OrderDate)) AS NumeroPedidos
	FROM Orders
	GROUP BY CustomerID, OrderDate

/* 5. ID del producto, precio unitario y total facturado de ese producto, ordenado por cantidad facturada de mayor a menor. 
	  Si hay varios precios unitarios para el mismo producto tomaremos el mayor. */

SELECT ProductID, (MAX (UnitPrice)) AS UnitPriceMayor, SUM (UnitPrice*Quantity) AS TotalFacturado
	FROM [Order Details]
	GROUP BY ProductID
	ORDER BY TotalFacturado DESC

/* 6. ID del proveedor e importe total del stock acumulado de productos correspondientes a ese proveedor. */

SELECT SupplierID, SUM (UnitsInStock) AS StockAcumuladoTotal 
	FROM Products
	GROUP BY SupplierID, UnitsInStock
	ORDER BY SupplierID

	--NO ESTA BIEN, CORREGIR.

/* 7. N�mero de pedidos registrados mes a mes de cada a�o. */

SELECT COUNT (OrderDate) AS NumeroPedidosRegistrados
	FROM Orders
	GROUP BY MONTH (OrderDate)

/* 8. A�o y tiempo medio transcurrido entre la fecha de cada pedido (OrderDate) y la fecha en la que lo hemos 
	  enviado (ShipDate), en d�as para cada a�o. */

SELECT YEAR (OrderDate) AS A�o, AVG (DAY(OrderDate)) AS TiempoMedioTranscurridoDias, DAY(ShippedDate) AS DiaEnvio
	FROM Orders
	GROUP BY OrderDate, ShippedDate

/* 9. ID del distribuidor y n�mero de pedidos enviados a trav�s de ese distribuidor. */

SELECT SupplierID, 
	FROM Suppliers
	GROUP BY

/* 10. ID de cada proveedor y n�mero de productos distintos que nos suministra. */