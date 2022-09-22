# E-Product 

Bir işyerinde ürünleri sisteme kaydedip listeleyen,ürün listesinden arama yapabileceğimiz bir web uygulamasının RestAPI'nı oluşturdum.

Projeyi indirdikten sonra PostgreSQL bağlantısı için "application.properties"teki bağlantı ayarlarını kendi database bilgileriniz ile değiştirmelisiniz 
ve PostgreSQL (solmaz_project) adında bir şema oluşturmalısınız .

Projeyi çalıştırmadan önce Redis in bilgisayarınızda kurulu ve açık olduğundan emin olun.        
        
        spring.datasource.username={databaseUsername}
        spring.datasource.password={databasePassword}
        
Ardından projeyi çalıştırıp Postman üzerinden aşağıdaki requestleri test edebilirsiniz. 

### POSTMAN için gerekli bilgiler

#Requests

    {
        "id":1,
        "productName":"Elma",
        "expirationDay":"2022-02-04",
        "price":"4.4",
        "moneyType":"Tl",
        "active": true
    }
    
#POST   http://localhost:8080/products/new                (Girilen ürün bilgilerini kaydeder.)

#GET    http://localhost:8080/products                    (Databasedeki ürünlerin listesini getirir. )

#PUT    http://localhost:8080/products/{id}               (Idsi verilen ürün aktifse pasif,pasifse aktif olarak günceller.)

#GET    http://localhost:8080/products/name/{productName} (Ürün adına göre arama yapar ve aranan isme sahip ürünleri getirir.)

#GET    http://localhost:8080/products/active/{active}    (Aktif ürün listesini görmek için true, pasif ürün listesini görmek için false yazın.)

### Taslak kayıt işlemi (Redis)
#POST   http://localhost:8080/productCache/new            (Girilen ürün bilgilerini önbelleğe kaydeder.)

#GET    http://localhost:8080/productCache                (Ön bellekteki ürünlerin listesini getirir. )

#POST http://localhost:8080/productCache/transferDB/{id}  (Id si verilen önbellekteki ürünü Database'e gönderir.)

    Not : Database'e gönderilmeyen ürünler bir saat içerisinde önbellekten silinir.



