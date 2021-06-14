# desafio-quality


<h3>Para testar a aplicação acesse a <a href="https://www.getpostman.com/collections/72308831b9fe5cedc643">Postman Collection</a></h3>

<h3>Endpoint:</h3>
```javascript
POST /properties/value
```
    
<h3>Exemplo de Request:</h3>

```javascript
{
    "propName": "Casa da Pandora",
    "propDistrict": "Chatuba",
    "rooms": [
        {
            "roomName": "Bedroom",
            "roomWidth": 5,
            "roomLength": 10
        },
        {
            "roomName": "Living Room",
            "roomWidth": 5,
            "roomLength": 7
        }
    ]
}
```

<h3>Parâmetros:</h3>

| Nome              | Tipo | Descrição| 
|--------------------|--------------|--------------|  
| propName | String   | Nome da propriedade |
| propDistrict | String   | Bairro da propriedade |
| rooms | ArrayList   | Lista de cômodos |
| roomName| String    | Nome do cômodo  |
| roomWidth | Double   | Largura do cômodo |
| roomLength  | Double    | Comprimento do cômodo  |

<h3>Restrições de parâmetros</h3>
```javascript
propName:
 - Não pode estar vazio;
 - Deve iniciar com letra maiúscula;
 - Deve ter até 30 caracteres.
    
propDistrict:
    - Não pode estar vazio;
    - Deve ter até 45 caracteres.
    
rooms:
    roomName:
         - Não pode estar vazio;
         - Deve iniciar com letra maiúscula;
         - Deve ter até 30 caracteres.
    roomWidth:
         - Não pode estar vazio;
         - Não pode ter mais de 33 metros.
    roomWidth:
         - Não pode estar vazio;
         - Não pode ter mais de 25 metros. 
```

<h3>Exemplo de Response:</h3>

```javascript
{
    "totalSize": 85.0,
    "value": 2550.0,
    "biggestRoom": {
        "roomName": "Bedroom",
        "roomSize": 50.0
    },
    "sizePerRoom": [
        {
            "roomName": "Bedroom",
            "roomSize": 50.0
        },
        {
            "roomName": "Living Room",
            "roomSize": 35.0
        }
    ]
}
```


 


