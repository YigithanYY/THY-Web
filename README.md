# Öğrenci Kayıt ve Yönetim Sistemi

Bu proje, öğrenci kayıt ve yönetim işlemlerini gerçekleştirmek amacıyla geliştirilmiş bir web uygulamasını içerir. Aşağıda projenin gereksinimleri ve teknolojik detayları bulabilirsiniz.

## Gereklilikler

1. Yeni öğrenci kaydı yapabilen bir web sayfası olmalı.
2. Kayıtlı öğrenciler güncellenebilmeli, bu nedenle güncelleme yeteneği eklenmelidir.
3. Kayıtlı öğrenciler silinebilmeli, bu nedenle silme yeteneği eklenmelidir.
4. Tüm öğrenciler web sayfasında listelenebilmelidir.

## Teknolojik Gereklilikler

- Veritabanı olarak HSQLDB kullanılmalıdır. Veritabanı şeması ve SQL komutları için uygun dosyalar da sunulmalıdır.
- Veritabanı bağlantısı için Spring JDBC veya Spring Crud Repository kullanılmalıdır.
- Java Rest Servisi oluşturmak için Spring Boot kullanılmalıdır.
- Kullanıcı arayüzü için React ve PrimeReact kullanılmalıdır.
- Redux yerine React Hooks kullanılmalıdır.
- Java proje yapılandırması Maven tarafından yönetilmelidir.

## Ek Gereklilikler

- Kayıt için öğrenci kimliği, ad, soyad, cep telefonu numarası, şehir, ilçe ve açıklama alanları yeterlidir.
- Öğrenciye ait dosyalar yüklenebilmelidir. PrimeReact yükleme bileşeni kullanılabilir.
- Öğrenci cep telefonu numarası için giriş maskeleme bileşeni kullanılmalıdır.
- İlçeler, seçilen şehrin değerine göre dinamik olarak yüklenmelidir.
- İstemci ve sunucu tarafı doğrulamaları uygulanmalıdır.
- Spring ve React entegrasyonu Java Restful Servisleri ve Axios aracılığıyla yapılandırılmalıdır.
- Veri erişim yöntemleri ve servis yöntemleri için birim testleri uygulanmalıdır.

## Proje Yapısı

- Java kodları Back-end klasöründe bulunmaktadır.
- Veritabanı bilgileri Database klasöründe bulunmaktadır.
- Front-end kodları React-front klasöründe bulunmaktadır.

## Çalıştırma Talimatları

1. Veritabanı Ayarları:
   - Veritabanı bilgilerini 'Database' klasöründeki dosyaları inceleyin
   

2. Back-end:
   - 'Back-end' klasöründe bulunan Java kodlarını bir IDE'de açın.
   - Uygulamayı başlatın.
   - Tarayıcınızda 'http://localhost:8080' adresine giderek uygulamayı görüntüleyebilirsiniz.

3. Front-end:
   - 'React-front' klasörüne gidin.
   - Uygulamayı başlatmak için 'npm start' komutunu kullanın.

4. Tarayıcı:
   - Tarayıcınızda 'http://localhost:3000' adresine giderek uygulamayı görüntüleyebilirsiniz.

