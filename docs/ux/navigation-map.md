# Hayvan Çıkabilir — Navigation Map

## Amaç

Bu belge uygulamanın ana ekranlarını ve kullanıcıların ekranlar arasında nasıl hareket edeceğini tanımlar.

## Ana Akış

Uygulama açılır.

Kullanıcı oturum açmamışsa:

Welcome
→ Login / Register

Kullanıcı oturum açmışsa:

Main Application

## Main Application

Ana uygulama başlangıçta aşağıdaki temel alanlardan oluşacaktır:

* Feed
* Explore
* Create Post
* Activity
* Profile

Ana navigasyon mobil uygulamada bottom navigation üzerinden erişilebilir olacaktır.

## Feed

Kullanıcı:

* Gönderileri görüntüler
* Gönderi detayına gider
* Hayvan profiline gider
* Beğeni veya yorum aksiyonuna ulaşır

Feed
→ Post Detail
→ Animal Profile

## Explore

Kullanıcı:

* Yeni hayvanları
* Yeni içerikleri
* İleride öne çıkan hikâyeleri

keşfedebilir.

Explore ilk sürümde basit tutulabilir.

## Create Post

Paylaşım başlatıldığında kullanıcı önce paylaşım türünü seçer:

Create Post
→ Registered Animal Post
veya
→ Street Encounter

### Registered Animal Post

Kullanıcı:

* Yönettiği hayvanı seçer
* Fotoğraf seçer
* Açıklama ekler
* Paylaşır

### Street Encounter

Kullanıcı:

* Fotoğraf seçer
* Hayvan hakkında kısa bilgi ekler
* Hikâye yazar
* İsteğe bağlı yaklaşık konum ekler
* Paylaşır

## Activity

İlk sürümde uygulama içindeki önemli sosyal hareketlerin görüntülenebileceği alan olarak düşünülür.

Push notification bu navigasyon yapısının zorunlu parçası değildir.

## Profile

Kullanıcı:

* Kendi profilini görüntüler
* Yönettiği hayvanları görür
* Hayvan profiline gider
* Ayarlara ulaşır

Profile
→ Animal Profile
→ Edit Animal

## Detay Ekranları

Ana navigation altında sürekli sekme olmak zorunda olmayan ekranlar:

* Post Detail
* Comments
* Animal Profile
* User Profile
* Create Animal
* Edit Animal
* Settings

## Temel Navigation İlkesi

Navigation hedefleri mümkün olduğunca kimlik bilgisi üzerinden açılmalıdır.

Örneğin bir Animal Profile ekranına bütün hayvan nesnesini taşımak yerine ilgili hayvanın kimliği kullanılır ve ekran gerekli veriyi kendi akışı üzerinden elde eder.

Detaylı teknik navigation implementasyonu feature planları sırasında belirlenecektir.
