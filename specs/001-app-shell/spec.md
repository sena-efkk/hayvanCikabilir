# Feature Specification — App Shell

## Amaç

Hayvan Çıkabilir Android uygulamasının sonraki özelliklerin üzerine güvenli ve tutarlı biçimde eklenebileceği ilk çalışan uygulama iskeletini oluşturmak.

Bu feature gerçek backend veya gerçek kullanıcı verisi içermez.

## Kullanıcı Senaryosu

Kullanıcı uygulamayı açtığında Hayvan Çıkabilir uygulamasının temel mobil arayüzünü görebilmelidir.

Ana uygulama içerisinde temel bölümler arasında geçiş yapılabilmelidir.

## İlk Ana Bölümler

Uygulamanın ana navigation yapısında aşağıdaki bölümler bulunacaktır:

* Ana Akış
* Keşfet
* Paylaş
* Aktivite
* Profil

Bu aşamada ekranlar gerçek özellikleri uygulamak zorunda değildir.

Ama navigation ve ekran iskeletleri çalışmalıdır.

## Gereksinimler

### FR-001

Android uygulaması Jetpack Compose kullanmalıdır.

### FR-002

Uygulama açıldığında ana uygulama ekranı görüntülenmelidir.

### FR-003

Ana uygulamada bottom navigation bulunmalıdır.

### FR-004

Bottom navigation üzerinden şu bölümlere geçilebilmelidir:

* Feed
* Explore
* Create Post
* Activity
* Profile

### FR-005

Seçili navigation öğesi kullanıcı tarafından anlaşılabilir olmalıdır.

### FR-006

Her ana bölüm ayrı bir ekran sorumluluğu olarak modellenmelidir.

### FR-007

Uygulamanın ortak görsel kimliğinin ileride merkezi olarak değiştirilebilmesi için temel theme yapısı bulunmalıdır.

### FR-008

UI bileşenleri doğrudan backend veya veritabanına bağımlı olmamalıdır.

## Bu Feature İçinde Olmayacaklar

* Kullanıcı kaydı
* Login
* Backend bağlantısı
* Retrofit
* Veritabanı
* Gerçek feed
* Hayvan profili oluşturma
* Fotoğraf paylaşımı
* Beğeni
* Yorum
* Push notification

Bu özellikler sonraki feature specification'larında ele alınacaktır.

## Kabul Kriterleri

1. Android uygulaması başarıyla derlenebilmelidir.
2. Uygulama emulator veya gerçek cihazda açılabilmelidir.
3. Beş ana navigation bölümü görüntülenmelidir.
4. Kullanıcı navigation öğelerine dokunarak ekranlar arasında geçiş yapabilmelidir.
5. Ekran geçişleri uygulamanın çökmesine neden olmamalıdır.
6. Ortak theme yapısı tek bir merkezi yapıdan yönetilebilmelidir.
7. Feature gerçek backend olmadan çalışabilmelidir.

## Başarı Tanımı

Bu feature tamamlandığında elimizde henüz sosyal platform özellikleri olmayan ancak sonraki Android feature'larının üzerine eklenebileceği çalışan bir Hayvan Çıkabilir mobil uygulama iskeleti bulunmalıdır.
