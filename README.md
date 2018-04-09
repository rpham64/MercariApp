# MercariApp Project

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

