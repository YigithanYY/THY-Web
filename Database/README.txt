HSQL Veritabanı Çalıştırma Kılavuzu

Bu kılavuzda, HSQLDB (Hypersonic SQL) veritabanını nasıl çalıştırabileceğinizi adım adım açıklamaktadır.

1. HSQLDB JAR Dosyasını Edinme:
   - İlk olarak, HSQLDB'nin son sürümünü indirin: http://hsqldb.org/
   - İndirdiğiniz zip veya tar.gz dosyasını açın.
   - İçeride hsqldb-x.x.x.jar adında bir JAR dosyası bulacaksınız.

2. Komut İstemi (CMD) Kullanarak Sunucuyu Başlatma:
   - Komut istemini (CMD) açın.
   - HSQLDB'nin JAR dosyasının bulunduğu dizine gidin. Örnek: cd /path/to/hsqldb
   - Aşağıdaki komutu kullanarak veritabanı sunucusunu başlatın:
     java -cp hsqldb-x.x.x.jar org.hsqldb.Server --database.0 sinif

3. Yeni Bir Komut İstemi (CMD) Kullanarak İstemci Uygulamasını Başlatma:
   - Başka bir komut istemini (CMD) açın.
   - HSQLDB'nin JAR dosyasının bulunduğu dizine gidin.
   - İstemci uygulamasını başlatmak için aşağıdaki komutu kullanın:
     java -jar (jar dosyası adı) 

   Not: 
   - (jar dosyası adı) kısmını, indirdiğiniz JAR dosyasının adı ile değiştirin.
   
   - sinif, veritabanının adıdır.

4. Sunucuyu Kapatma:
   - Sunucuyu durdurmak için sunucu komut isteminde Ctrl + C tuş kombinasyonunu kullanabilirsiniz.

Bu kılavuzda belirtilen adımları takip ederek HSQLDB veritabanını başlatabilir ve istemci uygulaması üzerinden veritabanına erişebilirsiniz. Lütfen adımları doğru bir şekilde uyguladığınızdan emin olun. Herhangi bir sorunla karşılaşırsanız HSQLDB belgelerine başvurmayı unutmayın: http://hsqldb.org/doc/
