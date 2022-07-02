import SettingsStore from "../store/SettingsStore";

export const renderBg = ():void => {
    const next:HTMLDivElement = document.querySelector('#__next')!;
        const blob:Blob = new Blob([SettingsStore.bgImage]);
        const reader:FileReader = new FileReader();
        reader.onload = (e:ProgressEvent<FileReader>) => {
          let base64 = e.target?.result;
          next.style.backgroundImage = `url('${base64}')`;
          
        }
        reader.readAsDataURL(blob);
}