Nama : Rahmat Irfan Adie Purwatmoko<br>
NIM : H1D023079<br>
Shift Baru : D<br>
Shift Lama : B<br><br>
Demo<br>
<img src="https://github.com/user-attachments/assets/a3f009eb-ab23-46df-9ed6-019153a3bedb" width="300"><br><br>
Penjelasan alur<br>
1.Permintaan (UI): MainActivity meminta MainViewModel untuk mengambil data tim.<br>
2.Pengambilan (ViewModel): MainViewModel menggunakan coroutine untuk memanggil RetrofitInstance.api.getTeamDetails() di latar belakang.<br>
3.Jaringan (Retrofit): Retrofit mengirim permintaan GET ke API (football-data.org), menerima JSON, dan mengubahnya menjadi objek Kotlin (TeamResponse).<br>
4.Pembaruan (LiveData): MainViewModel menempatkan objek TeamResponse yang berhasil didapat ke dalam LiveData.<br>
5.Observasi (UI): MainActivity, yang sedang mengamati LiveData tersebut, secara otomatis menerima data baru. Data itu disimpan dalam variabel (currentTeamData) dan nama tim ditampilkan di header.<br>
6.Penyajian (UI Lain): Saat pengguna menekan tombol (misal: Skuad), data yang sudah tersimpan (currentTeamData.squad) dikirim ke SquadActivity melalui Intent untuk ditampilkan di RecyclerView.<br>
