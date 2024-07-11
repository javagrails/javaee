curl --location 'http://localhost:8080/api/users' \
--header 'Content-Type: application/xml' \
--header 'Accept: application/json' \
--data-raw '<user id="5000">
  <fullName>Salman</fullName>
  <email>salman@example.com</email>
  <dateOfBirth>1720641616712</dateOfBirth>
  <address>
    <current>
      <house>99</house>
      <road>100</road>
      <city>Dhaka</city>
    </current>
    <permanent>
      <village>Bilashpur</village>
      <union>Dhanbari</union>
      <district>Tangail</district>
    </permanent>
  </address>
</user>
'


