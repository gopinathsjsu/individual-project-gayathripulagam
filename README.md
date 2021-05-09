# individual-project-gayathripulagam

## Java Version
```
✗ java -version
openjdk version "1.8.0_275"
```

## Usage
### CSV
```
✗ java -cp individual-project-gayathripulagam.jar com.gayathri.Main src/main/resources/input.csv output.csv
Output successfully written to output.csv
```
```
✗ cat output.csv
CardNumber,CardType,ErrorMessage
5410000000000000,MasterCard,
4120000000000,Visa,
341000000000000,AmericanExpress,
6011000000000000,Discover,
123,,"Unsupported Card Type"
```

### JSON
```
✗ java -cp target/individual-project-gayathripulagam.jar com.gayathri.Main src/main/resources/input.json output.json
Output successfully written to output.json
```
```
✗ cat output.json
[ {
  "CardNumber" : "5410000000000000",
  "CardType" : "MasterCard",
  "ErrorMessage" : null
}, {
  "CardNumber" : "4120000000000",
  "CardType" : "Visa",
  "ErrorMessage" : null
}, {
  "CardNumber" : "341000000000000",
  "CardType" : "AmericanExpress",
  "ErrorMessage" : null
}, {
  "CardNumber" : "6011000000000000",
  "CardType" : "Discover",
  "ErrorMessage" : null
}, {
  "CardNumber" : "123",
  "CardType" : null,
  "ErrorMessage" : "Unsupported Card Type"
} ]
```

### XML
```
✗ java -cp target/individual-project-gayathripulagam.jar com.gayathri.Main src/main/resources/input.xml output.xml
Output successfully written to output.xml
```
```
<ArrayList>
  <item>
    <CardNumber>5410000000000000</CardNumber>
    <CardType>MasterCard</CardType>
    <ErrorMessage/>
  </item>
  <item>
    <CardNumber>4120000000000</CardNumber>
    <CardType>Visa</CardType>
    <ErrorMessage/>
  </item>
  <item>
    <CardNumber>341000000000000</CardNumber>
    <CardType>AmericanExpress</CardType>
    <ErrorMessage/>
  </item>
  <item>
    <CardNumber>6011000000000000</CardNumber>
    <CardType>Discover</CardType>
    <ErrorMessage/>
  </item>
  <item>
    <CardNumber>123</CardNumber>
    <CardType/>
    <ErrorMessage>Unsupported Card Type</ErrorMessage>
  </item>
</ArrayList>
```

## Validations
### Validation that required number of arguments are passed
```
✗ java -cp individual-project-gayathripulagam.jar com.gayathri.Main
Invalid syntax. Usage: java com.gayathri.Main <input file path> <output file path>
```

### Validation that input and output file extensions are same
```
✗ java -cp individual-project-gayathripulagam.jar com.gayathri.Main src/main/resources/input.csv output.xml
Exception in thread "main" java.lang.RuntimeException: Input and output extensions should be the same
```
### Validation that input file path exists
```
✗ java -cp individual-project-gayathripulagam.jar com.gayathri.Main input.csv output.csv
Exception in thread "main" java.lang.RuntimeException: Input path does not exist
```
