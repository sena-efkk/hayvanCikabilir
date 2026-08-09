# Hayvan Çıkabilir — Modül Sınırları

## Amaç

Backend tek bir uygulama olarak deploy edilse bile bütün iş kurallarının birbirine karışmasını önlemek.

Platform modüler monolit yaklaşımıyla geliştirilecektir.

Her modül belirli bir iş alanından sorumludur.

## Identity

Sorumlulukları:

* Kullanıcı kaydı
* Giriş
* Oturum ve kimlik doğrulama
* Kullanıcının sistem kimliği

Identity hayvan profillerini veya sosyal içerikleri yönetmez.

## Users

Sorumlulukları:

* Kullanıcı profili
* Kullanıcıya ait genel profil bilgileri
* Hesap görünümüyle ilgili kullanıcı verileri

Authentication davranışı Identity'nin sorumluluğundadır.

## Animals

Sorumlulukları:

* Hayvan profili
* Hayvanın temel bilgileri
* Hayvan ile yönetici kullanıcı arasındaki ilişki
* Hayvan profilinin yaşam döngüsü

Animals modülü sosyal gönderilerin içeriğini yönetmez.

## Posts

Sorumlulukları:

* Gönderi oluşturma
* Gönderi içeriği
* Gönderiye bağlı medya
* Kayıtlı hayvan gönderileri
* Street Encounter gönderileri

Beğeni ve yorum davranışlarının tamamı Posts modülünün içine gömülmemelidir.

## Interactions

Sorumlulukları:

* Beğeniler
* Yorumlar
* Takip ilişkileri

Sosyal etkileşim kurallarını yönetir.

## Feed

Sorumlulukları:

* Kullanıcıya gösterilecek gönderilerin seçilmesi
* Feed sıralaması
* Sayfalama
* İleride kişiselleştirme

Feed gönderinin sahibi değildir.

Gönderinin kaynağı Posts modülüdür.

## Moderation

Sorumlulukları:

* İçerik raporlama
* Kullanıcı engelleme
* Moderasyon durumları
* Güvenlik müdahaleleri

Moderasyon diğer modüllerin verilerini doğrudan sahiplenmez.

## Weekly Highlights

Sorumlulukları:

* Haftalık öne çıkan içerikler
* Haftanın hayvanı
* Haftanın hikâyesi
* İleride aday ve seçim kuralları

Bu modül MVP çekirdeğinin parçası değildir ve ilerleyen sürümlerde aktive edilecektir.

## Modüller Arası Temel Kural

Bir modül başka bir modülün iç detaylarına bağımlı olmamalıdır.

Modüller yalnızca ihtiyaç duydukları açık sözleşmeler veya tanımlanmış iletişim yolları üzerinden birbirleriyle çalışmalıdır.

Örneğin Feed modülü bir gönderiyi göstermek için Posts modülünün veritabanı ayrıntılarını sahiplenmemelidir.

## Başlangıç Modülleri

İlk geliştirme sürecinde öncelikli modüller:

1. Identity
2. Users
3. Animals
4. Posts

Sonraki aşamalarda:

5. Interactions
6. Feed
7. Moderation
8. Weekly Highlights

eklenecektir.

## Mimari İlke

Modül sınırları gelecekte mikroservise geçmek amacıyla oluşturulmaz.

Ana amaç bugünkü kod tabanının anlaşılır, değiştirilebilir ve kontrollü biçimde büyüyebilir kalmasıdır.
