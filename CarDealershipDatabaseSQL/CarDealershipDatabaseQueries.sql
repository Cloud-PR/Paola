################ STEP 4 TEST SQL QUERIES ##############
#1. Get all dealerships
SELECT * FROM dealerships;


#2. Find all vehicles for a specific dealership
SELECT *
FROM vehicles
WHERE vin IN (SELECT vin FROM inventory WHERE DealershipID = 1);

#3. Find a car by VIN
SELECT *
FROM vehicles
WHERE vin = 'JTHCE1D21E5000001';

#4. Find the dealership where a certain car is located, by VIN
SELECT *
FROM dealerships
JOIN inventory ON dealerships.DealershipID = inventory.DealershipID
WHERE inventory.vin = 'JTHCE1D21E5000001';

#5. Find all dealerships that have a certain car type
SELECT *
FROM dealerships
JOIN inventory ON dealerships.DealershipID = inventory.DealershipID
JOIN vehicles ON inventory.VIN = vehicles.VIN
WHERE vehicles.Make = 'BMW' AND vehicles.color = 'Black';

#6. Get all sales info for a specific dealer for a specific date range
SELECT salescontract.*, vehicles.*, dealerships.*
FROM salescontract
JOIN vehicles ON salescontract.vin = vehicles.vin
JOIN inventory ON vehicles.vin = inventory.vin
JOIN dealerships ON inventory.DealershipID = dealerships.DealershipID
WHERE dealerships.DealershipID = 2 AND salescontract.saledate BETWEEN '2023-03-01' AND '2023-04-01';
