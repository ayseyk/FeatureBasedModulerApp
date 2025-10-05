# MyApp

**MyApp** is an Android sample app built with **feature-based, multi-module Compose Navigation** architecture.

---

## 🚀 Features

- Feature-based modular structure (`feature-profile`, `feature-home`, `feature-signup`)
- Deep link support (`mma://profile/edit/{userId}` etc.)
- Centralized route and graph management (`Graphs.kt`, `Routes.kt`)
- Compose Navigation with modular graphs and back stack handling

---

## 📂 Project Structure
- **app/** – Root module, contains `NavHost` and `MainActivity`
- **core/**
  - **common/** – Route, Graph, and DeepLinks definitions
  - **data/** – Repository and data sources
  - **domain/** – Use-cases and domain models
- **feature-profile/** – Profile feature module
- **feature-home/** – Home feature module
- **feature-signup/** – Signup feature module
---

## 🧭 Navigation

- Each feature exports its own graph (`NavGraphBuilder` extension)
- Deep links open the respective feature, with back stack managed manually if needed

---

## 🔗 Deep Link Examples

| Deep Link                     | Target Screen                 |
|-------------------------------|-------------------------------|
| `mma://signup`               | SignupScreen                  |
| `mma://home`                 | HomeScreen                     |
| `mma://profile/edit/123`     | EditProfileScreen(userId=123) |

---

## ⚡ Testing Deep Link (adb)

```bash
adb shell am start -a android.intent.action.VIEW -d "mma://profile/edit/123" com.ays.mma
