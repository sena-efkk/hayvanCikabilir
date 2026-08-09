# Hayvan Çıkabilir — Tasarım İlkeleri

## Fotoğraf Öncelikli

Platformun ana içeriği hayvanlar olduğu için fotoğraflar arayüzden daha baskın olmalıdır.

UI içeriğin önüne geçmemelidir.

## Sıcak ama Çocuksu Olmayan

Tasarım:

* Samimi
* Pozitif
* Yumuşak
* Modern

olmalıdır.

Ancak oyuncak veya yalnızca çocuklara yönelik bir uygulama görünümü oluşturmamalıdır.

## Basit Eylemler

Temel işlemler kolay bulunmalıdır:

* Paylaş
* Beğen
* Yorum yap
* Hayvan profilini aç
* Geri dön

Kullanıcı temel bir eylem için menüler arasında kaybolmamalıdır.

## Tutarlı Bileşenler

Aynı amaçtaki UI elemanları farklı ekranlarda farklı görünmemelidir.

Ortak tasarım sistemi kullanılacaktır.

Örneğin:

* Button
* Text Field
* Animal Avatar
* Post Card
* Loading
* Error
* Empty State

ortak tasarım diline sahip olacaktır.

## Durumlar Tasarımın Parçasıdır

Sadece başarılı ekran tasarlanmayacaktır.

Her önemli ekran gerektiğinde:

* Loading
* Empty
* Error
* Offline
* Disabled

durumlarını düşünmelidir.

## Erişilebilirlik

Metin okunabilirliği, dokunma alanları, kontrast ve içerik açıklamaları dikkate alınmalıdır.

Sadece görsel olarak güzel olmak yeterli değildir.

## Güvenlik ve Mahremiyet

Özellikle Street Encounter gibi özelliklerde kullanıcıya hassas bilgi paylaşması teşvik edilmemelidir.

Konum ve benzeri bilgiler varsayılan olarak güvenli seviyede ele alınmalıdır.

## Genişletilebilir Tasarım

Yeni özellikler eklendikçe mevcut ekranlar sürekli yeniden tasarlanmak zorunda kalmamalıdır.

Bunun için:

* Ortak spacing
* Typography
* Shapes
* Colors
* Reusable components

merkezi bir design system içerisinde yönetilmelidir.

Detaylı renk paleti ve görsel kimlik, uygulama iskeleti feature'ı sırasında belirlenecektir.
