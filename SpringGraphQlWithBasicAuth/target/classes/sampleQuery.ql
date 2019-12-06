//This query will retrieve 4 records from Vehicle table.
query {
    vehicles(count : 4) {
        id,
        type,
        modelCode,
        brandName,
    }
}

//This mutation will add new vehicle with given property values into vehicle table.
mutation {
  createVehicle(type: "car", modelCode: "XYZ0192", brandName: "XYZ") 
  {
    id
  }
}

//This mutation will delete vehicle from Vehicle table with given id. 
mutation {
    deleteVehicle(id : 4)
}

//This mutation will update vehicle with given id and will set given properties to that vehicle.
mutation {
  updateVehicle(id: 6,type: "Bike", modelCode: "XYZ0192", brandName: "XYZ") 
  {
    id
  }
}
