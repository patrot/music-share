
#API spec for Music Share library


| URI                         | HTTP Method | HTTP Response | Description                                              |
|-----------------------------|-------------|---------------|----------------------------------------------------------|
| /api/v1/musicshare/playlists | GET         | 200           | List all the available playlist                          || 
| /api/v1/musicshare/playlist | POST        | 201           | Create New playlist                                      |
| /api/v1/musicshare/playlist | POST        | 400           | Throws bad request when playlist is created with no name |
