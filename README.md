# MercariApp Project

![](https://lh3.googleusercontent.com/0JYUdbEVDNJr8H1vuFl8wC05h8xUZ4l7SLX4CMipNH1EtDd4gjP6DB-1L-OW3swkW1idNC8weurxnK7S6GRZo53X3NwYzUY-o3bthyaD_mdlbxEGsyxV8vqvO2EGfA4kJRacogi4knlWCLj0NU3D7lg6x3ibggbo1EERg8VaRjiDy25ntjZbRy1KqYUis761Kd2AC2AtGw0x5JiseMbZbkG9I61ZM7qYO2PemgCp1ZgF5I3G0idS4pVLlYKpXpj1a7fHgSQ-Djzpf6cUefvNXgTZrVylQHoajn5W1vbfTMQUmETEZ3SPpeauXE3fVEg69vudtU8IDPfEGyw6U8FA5LXw9cqOZBkZi6Wx6Pc0IOUtYrQWIQhxGKGIgrjD0Efd2Bm2Wm2meWkTz9wHAmO-h6SsdhTGYCafRBb6PA3Giu9wjwM9ghlaj_GRwUP6OsniTJuD7cjiR11y66NMPGSj-vipf6hUEHEicAH3HndaqdhyJhJEtwy7SceQ0nKj1j2iccpclplGbxWqS0-Jyimw2TdPKyslp4juW_H1lcfzexGRu8HTUWX0UgWAJE_py4fPfiCGfHPxZXPqZjaGzL5i_dLGCkPAP-TQ3OvBnAc2=w746-h1325-no)

An Android app provided by Mercari for displaying a grid of items on the marketplace with their respective name, price, picture, and other information.

## Developer's Information

Regarding architecture, I decided to build this app using the Model-View-Presenter pattern.
My reason for doing this is to easily decouple the view and business logic from one class into each of their own respective
classes, making the code easier to read and understand.

To explain further on my choices of classes in this project:

- MainActivity: This class does only one thing, which is to manage MainFragment.
- MainFragment: This class represents the View of the MVP design pattern by only handling changes to the UI and displaying content. This class uses a RecyclerView for displaying the list of items from the Response, which is passed to it by the MainPresenter.
- MainPresenter: This class represents the Presenter of the MVP design pattern. Here, the data from all.json is passed into it and then displayed in MainFragment using the updateUI() method.
- Item, Response: These two classes represent the Model of the MVP design pattern and contain the data fetched from the all.json class.

Other classes:

- MainAdapter: This RecyclerView adapter creates the ViewHolders necessary for MainFragment's RecyclerView and binds each of the Response's Items into their respective ViewHolder.
- BasePresenter: Acts as a parent interface or contract for passing methods down to MainPresenter.
- BaseView: Acts as a parent interface or contract for passing methods down to MainFragment.
- RestClient: An optional class for handling network calls using Retrofit and RxJava. As the data in this project was contained within a json file and not on the network, I've added some basic methods representing ways to use Retrofit and RxJava to pull data.
- MercariApp: In this application class, I've instantiated the OkHttpClient and RestClient class above for using with Retrofit and RxJava.

