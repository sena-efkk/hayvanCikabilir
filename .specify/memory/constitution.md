# Hayvan Çıkabilir — Project Constitution

## I. Spec-First Development

Yeni bir özellik doğrudan kodlanmamalıdır.

Her anlamlı özellik şu sırayı takip etmelidir:

1. Specification
2. Gereksinim netleştirme
3. Teknik plan
4. Uygulanabilir görevlar
5. Spec-plan-task tutarlılık kontrolü
6. Implementation
7. Test ve diff incelemesi

Specification ve teknik plan onaylanmadan implementation başlatılmamalıdır.

## II. Product Requirements Before Technology

Teknoloji seçimi ürün gereksiniminin önüne geçmemelidir.

Yeni bir teknoloji yalnızca:

* Gerçek bir problemi çözüyorsa
* Mevcut çözüm yetersizse
* Ek karmaşıklığı gerekçelendirilebiliyorsa

projeye eklenmelidir.

“Mimari olarak güzel görünmesi” tek başına teknoloji ekleme gerekçesi değildir.

## III. Modular Monolith First

Backend başlangıçta modüler monolit olacaktır.

Ana iş alanları açık modül sınırlarıyla ayrılmalıdır.

Başlangıçta öngörülen modüller:

* Identity
* Users
* Animals
* Posts
* Interactions
* Feed
* Moderation
* Weekly Highlights

Modüller başka modüllerin iç implementasyon ayrıntılarına gereksiz şekilde bağımlı olmamalıdır.

Mikroservis, message broker veya dağıtık sistem altyapısı gerçek ihtiyaç oluşmadan eklenmemelidir.

## IV. Clear Domain Ownership

Her iş kuralının açık bir sahibi olmalıdır.

Özellikle:

* User ve Animal farklı domain kavramlarıdır.
* Animal ile Street Encounter aynı kavram değildir.
* Post içerik yaşam döngüsünden sorumludur.
* Interaction sosyal etkileşimlerden sorumludur.
* Feed gönderilerin sahibi değildir; onları seçer ve sunar.

Aynı iş kuralı birden fazla modülde tekrar edilmemelidir.

## V. Android Architecture Boundaries

Android uygulaması feature tabanlı geliştirilecektir.

UI:

* Doğrudan HTTP isteği yapmamalıdır.
* Doğrudan ana veri kaynağına erişmemelidir.
* İş kurallarını Composable içerisine gömmemelidir.

Temel veri akışı tek yönlü olmalıdır:

UI Event
→ ViewModel
→ Application / Repository
→ Data Source

State
→ ViewModel
→ UI

UI state açık ve test edilebilir olmalıdır.

## VI. API Is a Contract

Android ile backend arasındaki API geçici bir implementation detayı değildir.

API sözleşmeleri:

* Açık
* Tutarlı
* Geriye uyumluluğu gözeten
* Hata davranışları tanımlı

olmalıdır.

Mobil uygulamanın eski sürümlerini gereksiz yere bozacak contract değişikliklerinden kaçınılmalıdır.

Kırıcı değişiklikler açıkça gerekçelendirilmelidir.

## VII. Database Changes Must Be Controlled

Veritabanı şeması kontrollü migration'larla değiştirilmelidir.

Migration'lar:

* Mevcut veriyi gereksiz yere kaybetmemeli
* Geriye uyumluluğu dikkate almalı
* Production verisi varmış gibi değerlendirilmelidir

Şema değişiklikleri yalnızca geliştirme kolaylığı için rastgele yapılmamalıdır.

## VIII. Security Is Server-Enforced

Mobil istemci güvenilir bir sistem sınırı değildir.

Kimlik doğrulama, yetkilendirme ve kritik iş kuralları backend tarafından doğrulanmalıdır.

Android uygulamasında bir butonun gizlenmesi güvenlik önlemi sayılmaz.

Bir kullanıcı yalnızca yetkisi bulunan kaynaklar üzerinde işlem yapabilmelidir.

## IX. User and Animal Safety

Hayvan Çıkabilir kullanıcı tarafından oluşturulan içerik barındıran bir platformdur.

Bu nedenle güvenlik ve moderasyon sonradan düşünülen yardımcı özellikler değildir.

Ürün geliştirilirken:

* Kullanıcı güvenliği
* Hayvan güvenliği
* Konum mahremiyeti
* İçerik raporlama
* Kullanıcı engelleme
* Yetkisiz hayvan sahipliği iddiaları

gibi riskler dikkate alınmalıdır.

Kesin konum gibi hassas bilgiler varsayılan olarak herkese açık tasarlanmamalıdır.

## X. Tests Follow Risk

Her dosya veya sınıf için anlamsız test yazılması zorunlu değildir.

Ancak aşağıdaki alanlar test edilmelidir:

* Kritik domain kuralları
* Yetkilendirme
* Veri bütünlüğü
* API contract davranışları
* Önemli kullanıcı akışları
* Hata ve edge-case davranışları

Test stratejisi feature planının parçası olmalıdır.

## XI. No Premature Complexity

Aşağıdaki teknolojiler gerçek ihtiyaç oluşmadan eklenmemelidir:

* Mikroservis
* Kubernetes
* Kafka
* RabbitMQ
* Event Sourcing
* Elasticsearch
* Redis
* Server-driven UI
* Ayrı read/write veritabanları

Yeni altyapı eklemeden önce mevcut yapının neden yetersiz olduğu açıklanmalıdır.

## XII. Extensibility Without Speculation

Sistem yeni özellikler eklenebilecek şekilde tasarlanmalıdır.

Ancak gelecekte belki gerekli olur düşüncesiyle:

* Gereksiz interface
* Gereksiz generic abstraction
* Gereksiz base class
* Gereksiz repository
* Gereksiz servis katmanı

oluşturulmamalıdır.

Genişletilebilirlik, doğru sorumluluk sınırlarından gelmelidir; aşırı soyutlamadan değil.

## XIII. Documentation Has Ownership

Belgelerin görevleri karıştırılmamalıdır.

### `docs/product`

Ürün kararlarının kaynağıdır.

### `docs/architecture`

Sistem genelindeki mimari kararların kaynağıdır.

### `docs/ux`

Genel kullanıcı deneyimi ve navigation kararlarının kaynağıdır.

### `specs/<feature>`

Tek bir özelliğin gereksinim, plan, veri modeli, contract ve görevlerinin kaynağıdır.

Bir feature'a özel detay global dokümanlara gereksiz yere taşınmamalıdır.

## XIV. Human Review Gates

Kod ajanı kritik aşamalarda otomatik olarak sonraki aşamaya geçmemelidir.

Her feature için dört temel kontrol noktası vardır:

### Gate 1 — Specification

Ne yaptığımız doğru mu?

### Gate 2 — Technical Plan

Nasıl yapacağımız doğru mu?

### Gate 3 — Tasks

İş sırası ve kapsam doğru mu?

### Gate 4 — Implementation

Kod, migration, testler ve diff belgelerle uyumlu mu?

Bir gate onaylanmadan sonraki kritik aşamaya geçilmemelidir.

## XV. Evolution Over Rewrite

Platform sürüm sürüm büyütülecektir.

Yeni özelliklerin eklenmesi mevcut sistemi gereksiz yere yeniden yazmayı gerektirmemelidir.

Tercih edilen yaklaşım:

Küçük çalışan çekirdek
→ Gerçek kullanım
→ Yeni gereksinim
→ Kontrollü genişleme

Ürünün geleceği tahmin edilerek değil, doğrulanan ihtiyaçlara göre geliştirilmelidir.

---

## Governance

Bu constitution proje genelindeki teknik geliştirme ilkelerinin en üst seviyedeki kaynağıdır.

Bir feature planı constitution ile çelişiyorsa:

1. Önce çelişki açıkça belirtilmelidir.
2. Mevcut yaklaşımın neden yetersiz olduğu açıklanmalıdır.
3. Gerekirse constitution bilinçli şekilde güncellenmelidir.
4. Constitution sessizce ihlal edilmemelidir.

Ürün gereksinimleri değişebilir.

Teknik tercihler değişebilir.

Ancak değişiklikler açık gerekçe ve kontrollü migration ile yapılmalıdır.
