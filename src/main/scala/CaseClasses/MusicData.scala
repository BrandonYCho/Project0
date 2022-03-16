package CaseClasses

case class MusicData(
                      TrackID: String,
                      //ISRC: String, cannot use since exportify does not provide this, WANT TO USE LATER when I can export myself using spotify API
                      Title: String,
                      Artist: String,
                      Album: String,
                      Duration: Int,
                      Genre: String
                    )
