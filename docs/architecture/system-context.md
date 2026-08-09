# Hayvan Çıkabilir — System Context

## Amaç

Bu belge Hayvan Çıkabilir platformunun ana sistem parçalarını ve aralarındaki temel ilişkileri tanımlar.

Detaylı teknoloji veya kod organizasyonu bu belgenin kapsamı değildir.

## Ana Sistemler

Platform başlangıçta üç ana çalışma alanından oluşacaktır.

### Android Application

Kullanıcının platformla doğrudan etkileşim kurduğu mobil uygulamadır.

Android uygulaması:

* Kullanıcı arayüzünü gösterir
* Kullanıcı eylemlerini alır
* Backend API ile iletişim kurar
* Platform verilerini kullanıcıya sunar

Android uygulaması doğrudan ana veritabanına erişmez.

### Backend API

Platformun iş kurallarının ve merkezi uygulama davranışının bulunduğu sistemdir.

Backend:

* Kullanıcı işlemlerini yönetir
* Hayvan profillerini yönetir
* Gönderileri yönetir
* Sosyal etkileşimleri yönetir
* Yetkilendirme uygular
* Verilerin güvenli biçimde saklanmasını sağlar

Mobil uygulama ile veri kaynakları arasındaki ana sınır backend API'dir.

### Data and Media Storage

Platform iki temel veri türü saklar.

#### Structured Data

Örneğin:

* Kullanıcılar
* Hayvan profilleri
* Gönderiler
* Yorumlar
* Beğeniler
* Takip ilişkileri

ilişkisel veri deposunda tutulur.

#### Media

Örneğin:

* Hayvan profil fotoğrafları
* Gönderi fotoğrafları

ayrı medya depolama alanında tutulur.

Veritabanının görevi büyük medya dosyalarını doğrudan saklamak değildir.

## Temel Sistem Akışı

Ana iletişim modeli:

Android Application
→ Backend API
→ Data / Media Storage

Backend gerekli sonucu üretir ve Android uygulamasına döndürür.

## Yönetim Sınırı

Kullanıcı cihazı güvenilir sistem sınırı olarak kabul edilmez.

Kritik iş kuralları ve yetkilendirme kontrolleri backend tarafında uygulanmalıdır.

Örneğin:

Bir kullanıcı Android uygulamasını değiştirerek başka bir kullanıcının hayvanını düzenlemeye çalışsa bile backend buna izin vermemelidir.

## İlk Mimari Sınır

İlk sürümde platform dağıtık mikroservis sistemi olarak tasarlanmayacaktır.

Amaç:

* Tek deploy edilebilen backend
* Açık modül sınırları
* Ayrı Android uygulaması
* Merkezi veri yönetimi

ile sade fakat genişletilebilir bir temel oluşturmaktır.

## Gelecekte Eklenebilecek Sistemler

İhtiyaç doğrulanırsa ileride:

* Web yönetim paneli
* Background worker'lar
* Profesyonel hesap sistemleri
* Harici bildirim sistemleri
* Analitik sistemleri
* Ek medya işleme servisleri

eklenebilir.

Bu sistemler mevcut ihtiyaç oluşmadan ana mimariye dahil edilmeyecektir.
